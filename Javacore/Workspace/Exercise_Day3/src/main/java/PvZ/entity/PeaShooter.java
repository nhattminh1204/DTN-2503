package PvZ.entity;

public class PeaShooter extends GameObject implements Shooter {

    public PeaShooter(int x, int y) {
        super(100, x, y);
    }

    @Override
    public void shoot(GameObject target) {
        if (this.isAlive() && target != null && target.isAlive()) {
            System.out.println("PeaShooter at (" + getX() + ", " + getY()
                    + ") shoots " + target.getClass().getSimpleName()
                    + " at (" + target.getX() + ", " + target.getY() + ")");
            target.takeDamage(20);
        }
    }

    @Override
    public void update() {
        System.out.println("PeaShooter at (" + getX() + ", " + getY()
                + ") - HP: " + getHealth());
    }
}