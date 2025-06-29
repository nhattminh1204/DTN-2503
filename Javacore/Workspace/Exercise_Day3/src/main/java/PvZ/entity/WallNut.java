package PvZ.entity;

public class WallNut extends GameObject {

    public WallNut(int x, int y) {
        super(300, x, y); // Máu rất cao
    }

    @Override
    public void update() {
        System.out.println("WallNut at (" + getX() + ", " + getY()
                + ") stands firm. HP: " + getHealth());
    }
}