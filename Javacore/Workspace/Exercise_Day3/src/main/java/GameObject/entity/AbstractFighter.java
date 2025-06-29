package GameObject.entity;

public abstract class AbstractFighter implements Fighter {
    protected String name;
    protected int mana;
    protected int blood;
    protected int damage;
    protected int manaCost;

    public AbstractFighter(String name, int mana, int blood, int damage, int manaCost) {
        this.name = name;
        this.mana = mana;
        this.blood = blood;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    @Override
    public boolean isAlive() {
        return blood > 0;
    }

    @Override
    public void takeDamage(int damage) {
        blood -= damage;
        System.out.println(name + " bị mất " + damage + " máu. Máu còn: " + blood);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getBlood() {
        return blood;
    }

    @Override
    public void recover() {
        int recoverAmount = 30;
        mana = Math.min(mana + recoverAmount, getMaxMana());
    }
}
