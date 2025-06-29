package Flyweight_1;

public class SoldierType implements Soldier {
    private final String vuKhi;
    private final String trangPhuc;

    public SoldierType(String vuKhi, String trangPhuc) {
        this.vuKhi = vuKhi;
        this.trangPhuc = trangPhuc;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Lính tại (" + x + ", " + y + ") | Vũ khí: " + vuKhi + ", Trang phục: " + trangPhuc);
    }
}
