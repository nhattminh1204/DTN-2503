package Adapter_2;

public class PaymentClient {
    private PaymentProcessor paymentProcessor;

    public PaymentClient(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(double amount) {
        paymentProcessor.pay(amount);
    }
}
