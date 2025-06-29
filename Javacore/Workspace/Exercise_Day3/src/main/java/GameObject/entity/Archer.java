package GameObject.entity;

public class Archer extends AbstractFighter {

    public Archer(String name, int mana, int blood, int damage, int manaCost) {
        super(name, mana, blood, damage, manaCost);
    }

    @Override
    public void attack(Fighter target) {
        if (!isAlive()) {
            System.out.println(name + " đã gục ngã, không thể tấn công.");
            return;
        }

        if (mana >= manaCost) {
            System.out.println(name + " bắn Đại Băng Tiễn vào " + target.getName() + ", gây " + damage + " sát thương!");
            mana -= manaCost;
            target.takeDamage(damage);
        } else {
            System.out.println(name + " không đủ mana để sử dụng Đại Băng Tiễn.");
        }
    }

    @Override
    public int getMaxMana() {
        return 1300;
    }

    @Override
    public int getMaxBlood() {
        return 1200;
    }
}
