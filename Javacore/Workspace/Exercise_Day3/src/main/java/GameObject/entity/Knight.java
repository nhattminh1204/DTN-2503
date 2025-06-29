package GameObject.entity;

public class Knight extends AbstractFighter {

    public Knight(String name, int mana, int blood, int damage, int manaCost) {
        super(name, mana, blood, damage, manaCost);
    }

    @Override
    public void attack(Fighter target) {
        if (!isAlive()) {
            System.out.println(name + " đã gục ngã, không thể tấn công.");
            return;
        }

        if (mana >= manaCost) {
            System.out.println(name + " sử dụng Trăn trối lên " + target.getName() + ", gây " + damage + " sát thương!");
            mana -= manaCost;
            target.takeDamage(damage);
        } else {
            System.out.println(name + " không đủ mana để tấn công.");
        }
    }

    @Override
    public int getMaxMana() {
        return 1400;
    }

    @Override
    public int getMaxBlood() {
        return 1500;
    }
}
