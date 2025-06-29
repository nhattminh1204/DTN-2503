package Strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new BitcoinPayment("1A2b3C4D5e6F7G8H9"));
        cart.checkout(5000000);

        cart.setPaymentStrategy(new CreditCardPayment("4111-2222-3333-4444"));
        cart.checkout(7500000);

        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(280000);
    }
}
