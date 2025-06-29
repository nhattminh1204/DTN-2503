package PvZ.entity;

public class FastZombie extends Zombie {

    public FastZombie(int x, int y) {
        super(80, x, y); // Máu ít hơn Zombie thường
    }

    @Override
    public void move() {
        if (isAlive()) {
            setX(getX() - 2); // Di chuyển nhanh gấp đôi
        }
    }

    @Override
    public void update() {
        move();
        System.out.println("FastZombie at (" + getX() + ", " + getY()
                + ") - HP: " + getHealth());
    }
}