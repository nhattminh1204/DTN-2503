package Adapter_2;

public class Program {
    public static void main(String[] args) {
        // Thanh toán qua PayPal
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentClient client1 = new PaymentClient(paypalProcessor);
        client1.makePayment(100.0);

        // Thanh toán qua Stripe
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentClient client2 = new PaymentClient(stripeProcessor);
        client2.makePayment(200.0);

        // Thanh toán qua Crypto
        PaymentProcessor cryptoProcessor = new CryptoAdapter(new Crypto());
        PaymentClient client3 = new PaymentClient(cryptoProcessor);
        client3.makePayment(300.0);
    }
}
