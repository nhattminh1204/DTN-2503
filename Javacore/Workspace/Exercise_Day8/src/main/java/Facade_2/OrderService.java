package Facade_2;

public class OrderService {
    private Inventory inventory;
    private PaymentGateway paymentGateway;
    private Shipping shipping;
    private Notification notification;

    public OrderService() {
        this.inventory = new Inventory();
        this.paymentGateway = new PaymentGateway();
        this.shipping = new Shipping();
        this.notification = new Notification();
    }

    public void placeOrder(String productId, int quantity, double price,
                           String account, String address, String email) {
        System.out.println("\n--- BẮT ĐẦU ĐẶT HÀNG ---");

        if (!inventory.checkStock(productId, quantity)) {
            System.out.println("Không đủ hàng trong kho.");
            return;
        }

        if (!paymentGateway.processPayment(account, price)) {
            System.out.println("Thanh toán thất bại.");
            return;
        }

        inventory.reserve(productId, quantity);
        shipping.createShipment(address);
        notification.sendEmail(email, "Đơn hàng của bạn đã được xử lý thành công!");

        System.out.println("--- ĐẶT HÀNG THÀNH CÔNG ---");
    }
}
