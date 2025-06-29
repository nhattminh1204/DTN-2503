package GameObject.service;

import GameObject.entity.*;
import java.util.*;

public class BattleManagement {
    private List<Fighter> allFighters;
    private List<Fighter> playerTeam;
    private List<Fighter> enemyTeam;

    public BattleManagement() {
        allFighters = new ArrayList<>(Arrays.asList(
                new Knight("Yasuo", 1500, 1500, 250, 80),
                new Archer("Ashe", 1400, 1200, 300, 100),
                new Mage("Kathus", 1500, 1000, 350, 180),
                new Knight("Garen", 1600, 1500, 270, 90),
                new Mage("Lux", 1300, 1000, 320, 150)
        ));
        playerTeam = new ArrayList<>();
        enemyTeam = new ArrayList<>();
    }

    public void displayFighters() {
        for (int i = 0; i < allFighters.size(); i++) {
            System.out.println((i + 1) + ". " + allFighters.get(i).getName());
        }
    }

    public void choosePlayerTeam(Scanner sc) {
        System.out.println("Chọn 2 chiến binh cho đội của bạn:");
        displayFighters();

        while (playerTeam.size() < 2) {
            System.out.print("Chọn chiến binh số: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice >= 1 && choice <= allFighters.size()) {
                Fighter selected = allFighters.get(choice - 1);
                if (!playerTeam.contains(selected)) {
                    playerTeam.add(selected);
                    System.out.println("Đã chọn: " + selected.getName());
                } else {
                    System.out.println("Chiến binh đã được chọn.");
                }
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void setEnemyTeam() {
        Random random = new Random();
        while (enemyTeam.size() < 2) {
            Fighter f = allFighters.get(random.nextInt(allFighters.size()));
            if (!playerTeam.contains(f) && !enemyTeam.contains(f)) {
                enemyTeam.add(f);
            }
        }
        System.out.println("Đội đối thủ đã sẵn sàng:");
        for (Fighter f : enemyTeam) {
            System.out.println(" - " + f.getName());
        }
    }

    public void startBattle() {
        int round = 1;
        Random random = new Random();

        while (!playerTeam.isEmpty() && !enemyTeam.isEmpty()) {
            System.out.println("\n--------- Round " + round + " ---------");

            for (Fighter player : new ArrayList<>(playerTeam)) {
                if (player.isAlive() && !enemyTeam.isEmpty()) {
                    Fighter target = enemyTeam.get(random.nextInt(enemyTeam.size()));
                    player.attack(target);
                    player.recover();
                    displayStatus(player);
                    displayStatus(target);
                    if (!target.isAlive()) enemyTeam.remove(target);
                }
            }

            for (Fighter enemy : new ArrayList<>(enemyTeam)) {
                if (enemy.isAlive() && !playerTeam.isEmpty()) {
                    Fighter target = playerTeam.get(random.nextInt(playerTeam.size()));
                    enemy.attack(target);
                    enemy.recover();
                    displayStatus(enemy);
                    displayStatus(target);
                    if (!target.isAlive()) playerTeam.remove(target);
                }
            }

            round++;
        }

        if (!playerTeam.isEmpty()) {
            System.out.println("🎉 Đội bạn chiến thắng!");
        } else if (!enemyTeam.isEmpty()) {
            System.out.println("💀 Đội đối thủ chiến thắng!");
        } else {
            System.out.println("⚔️ Cả hai đội đều bị tiêu diệt!");
        }
    }

    private void displayStatus(Fighter fighter) {
        System.out.println("[" + fighter.getName() + "] HP: " + fighter.getBlood() + "/" + fighter.getMaxBlood()
                + " | Mana: " + fighter.getMana() + "/" + fighter.getMaxMana());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BattleManagement game = new BattleManagement();
        System.out.println("=== GAME ĐẤU CHIẾN BINH ===");
        game.choosePlayerTeam(sc);
        game.setEnemyTeam();
        game.startBattle();
    }
}
