package Adapter_2;

public class CryptoAdapter implements PaymentProcessor {
    private Crypto crypto;

    public CryptoAdapter(Crypto crypto) {
        this.crypto = crypto;
    }

    @Override
    public void pay(double amount) {
        crypto.transferCrypto(amount);
    }
}
