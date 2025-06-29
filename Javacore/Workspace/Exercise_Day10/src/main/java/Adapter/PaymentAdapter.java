package Adapter;

public class PaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldPaymentSystem;

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    @Override
    public void processPayment(double amount) {
        oldPaymentSystem.makePayment(amount);
    }
}
