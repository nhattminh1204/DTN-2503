package Decorator_2;

public class EncryptionDecorator extends EmailDecorator {
    public EncryptionDecorator(EmailSender sender) {
        super(sender);
    }

    private String encrypt(String message) {
        return "[Encrypted] " + message;
    }

    @Override
    public void send(String message) {
        String encrypted = encrypt(message);
        super.send(encrypted);
    }
}
