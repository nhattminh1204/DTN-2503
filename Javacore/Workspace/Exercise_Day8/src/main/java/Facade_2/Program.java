package Facade_2;

public class Program {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // Đặt hàng 1 sản phẩm
        orderService.placeOrder(
                "SP001",        // mã sản phẩm
                2,              // số lượng
                500.0,          // tổng tiền
                "acc123",       // tài khoản thanh toán
                "123 Lê Lợi, Huế",  // địa chỉ giao hàng
                "khachhang@email.com" // email nhận thông báo
        );
    }
}
