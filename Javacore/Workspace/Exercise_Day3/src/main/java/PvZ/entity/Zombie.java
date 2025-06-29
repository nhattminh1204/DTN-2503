package PvZ.entity;

public class Zombie extends GameObject implements Mover, Attacker {
    public Zombie(int health, int x, int y) {
        super(health, x, y);
    }

    @Override
    public void move() {
        if (this.isAlive()) {
            setX(getX() - 1);
        }
    }

    @Override
    public void attack(GameObject target) {
        target.takeDamage(20);
        System.out.println("Zombie attacks " + target.getClass().getSimpleName()
                + " at (" + target.getX() + ", " + target.getY() + ")");
    }

    @Override
    public void update() {
        move();
        System.out.println("Zombie at (" + getX() + ", " + getY()
                + ") - HP: " + getHealth());
    }
}