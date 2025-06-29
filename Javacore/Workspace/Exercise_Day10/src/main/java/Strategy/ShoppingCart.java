package Strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Lỗi: Chưa chọn phương thức thanh toán!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
