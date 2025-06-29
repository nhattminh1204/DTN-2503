package Flyweight_1;

public class SoldierPosition {
    private final int x;
    private final int y;
    private final Soldier soldier; // shared Flyweight

    public SoldierPosition(int x, int y, Soldier soldier) {
        this.x = x;
        this.y = y;
        this.soldier = soldier;
    }

    public void render() {
        soldier.display(x, y); // truyền extrinsic vào method
    }
}
