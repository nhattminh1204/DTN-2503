package Strategy;

public class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " bằng Bitcoin từ ví: " + walletAddress);
    }
}
