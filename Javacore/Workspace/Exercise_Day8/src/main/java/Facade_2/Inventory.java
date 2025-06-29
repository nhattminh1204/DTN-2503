package Facade_2;

public class Inventory {
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Kiểm tra tồn kho cho sản phẩm: " + productId + " số lượng: " + quantity);
        return true;
    }

    public void reserve(String productId, int quantity) {
        System.out.println("Đã giữ hàng: " + productId + " x " + quantity);
    }
}
