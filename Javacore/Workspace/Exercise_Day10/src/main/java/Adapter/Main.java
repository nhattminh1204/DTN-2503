package Adapter;

public class Main {
    public static void main(String[] args) {
        OldPaymentSystem oldPaymentSystem = new OldPaymentSystem();

        PaymentAdapter paymentAdapter = new PaymentAdapter(oldPaymentSystem);

        paymentAdapter.processPayment(500000);
    }
}
