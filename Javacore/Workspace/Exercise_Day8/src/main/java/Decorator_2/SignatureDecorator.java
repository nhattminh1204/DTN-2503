package Decorator_2;

public class SignatureDecorator extends EmailDecorator {
    public SignatureDecorator(EmailSender sender) {
        super(sender);
    }

    private String sign(String message) {
        return message + " [Signed]";
    }

    @Override
    public void send(String message) {
        String signed = sign(message);
        super.send(signed);
    }
}
