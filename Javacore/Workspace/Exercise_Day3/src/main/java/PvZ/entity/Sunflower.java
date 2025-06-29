package PvZ.entity;

public class Sunflower extends GameObject {

    public Sunflower(int x, int y) {
        super(60, x, y);
    }

    public int generateEnergy() {
        System.out.println("Sunflower at (" + getX() + ", " + getY()
                + ") generates 25 energy");
        return 25;
    }

    @Override
    public void update() {
        generateEnergy();
        System.out.println("Sunflower at (" + getX() + ", " + getY()
                + ") - HP: " + getHealth());
    }
}