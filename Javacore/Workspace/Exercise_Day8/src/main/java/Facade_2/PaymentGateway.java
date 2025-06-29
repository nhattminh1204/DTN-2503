package Facade_2;

public class PaymentGateway {
    public boolean processPayment(String account, double amount) {
        System.out.println("Xử lý thanh toán cho tài khoản " + account + " với số tiền $" + amount);
        return true; // luôn thành công (giả lập)
    }
}
