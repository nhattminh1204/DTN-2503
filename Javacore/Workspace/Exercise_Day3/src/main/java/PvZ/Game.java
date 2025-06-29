package PvZ;

import PvZ.entity.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    private static final int BOARD_WIDTH = 10;
    private static final int TURN_DELAY = 1000; // 1 giây mỗi lượt

    public static void main(String[] args) {
        ArrayList<GameObject> plants = new ArrayList<>();
        ArrayList<GameObject> zombies = new ArrayList<>();

        // Khởi tạo cây
        plants.add(new PeaShooter(1, 1));
        plants.add(new PeaShooter(2, 2));
        plants.add(new Sunflower(0, 0));
        plants.add(new WallNut(4, 1));

        // Khởi tạo zombie
        zombies.add(new Zombie(100,15, 1));
        zombies.add(new FastZombie(20, 2));

        int turn = 1;
        while (true) {
            System.out.println("\n===== LƯỢT " + turn + " =====");

            processZombies(zombies, plants);
            processPlants(plants, zombies);

            // Kiểm tra kết thúc game
            if (checkGameOver(zombies)) {
                break;
            }

            // Hiển thị trạng thái
            displayGameStatus(plants, zombies);

            turn++;
            sleep(TURN_DELAY);
        }
    }

    private static void processZombies(ArrayList<GameObject> zombies, ArrayList<GameObject> plants) {
        Iterator<GameObject> zombieIter = zombies.iterator();
        while (zombieIter.hasNext()) {
            GameObject zombie = zombieIter.next();
            if (!zombie.isAlive()) continue;

            boolean blocked = false;

            Iterator<GameObject> plantIter = plants.iterator();
            while (plantIter.hasNext()) {
                GameObject plant = plantIter.next();

                if (plant.isAlive() && zombie.getX() == plant.getX() && zombie.getY() == plant.getY()) {
                    ((Attacker) zombie).attack(plant);

                    if (!plant.isAlive()) {
                        System.out.println(plant.getClass().getSimpleName()
                                + " tại (" + plant.getX() + "," + plant.getY()
                                + ") đã bị tiêu diệt!");
                        plantIter.remove();
                    }
                    blocked = true;
                    break;
                }
            }

            if (!blocked) {
                zombie.update();
            }
        }
    }

    private static void processPlants(ArrayList<GameObject> plants, ArrayList<GameObject> zombies) {
        Iterator<GameObject> plantIter = plants.iterator();
        while (plantIter.hasNext()) {
            GameObject plant = plantIter.next();
            if (!plant.isAlive()) {
                plantIter.remove();
                continue;
            }

            plant.update();

            if (plant instanceof PeaShooter) {
                GameObject target = findTarget(plant, zombies);
                if (target != null) {
                    ((PeaShooter) plant).shoot(target);
                }
            }
        }
    }

    private static GameObject findTarget(GameObject plant, ArrayList<GameObject> zombies) {
        GameObject closest = null;
        int minDistance = BOARD_WIDTH;

        for (GameObject z : zombies) {
            if (z.isAlive() && z.getY() == plant.getY() && z.getX() > plant.getX()) {
                int distance = z.getX() - plant.getX();
                if (distance < minDistance) {
                    closest = z;
                    minDistance = distance;
                }
            }
        }
        return closest;
    }

    private static boolean checkGameOver(ArrayList<GameObject> zombies) {
        // Kiểm tra thắng
        boolean allZombiesDead = zombies.stream().noneMatch(GameObject::isAlive);
        if (allZombiesDead) {
            System.out.println("\n***** CHIẾN THẮNG! Tất cả zombie đã bị tiêu diệt! *****");
            return true;
        }

        // Kiểm tra thua
        boolean zombieWin = zombies.stream().anyMatch(z -> z.isAlive() && z.getX() <= 0);
        if (zombieWin) {
            System.out.println("\n***** THẤT BẠI! Zombie đã xâm nhập vào nhà! *****");
            return true;
        }

        return false;
    }

    private static void displayGameStatus(ArrayList<GameObject> plants, ArrayList<GameObject> zombies) {
        System.out.println("\n--- TRẠNG THÁI HIỆN TẠI ---");
        System.out.println("CÂY:");
        plants.forEach(p -> System.out.println("- " + p.getClass().getSimpleName()
                + " tại (" + p.getX() + "," + p.getY()
                + ") HP: " + p.getHealth()));

        System.out.println("ZOMBIE:");
        zombies.forEach(z -> System.out.println("- " + z.getClass().getSimpleName()
                + " tại (" + z.getX() + "," + z.getY()
                + ") HP: " + z.getHealth()));
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}