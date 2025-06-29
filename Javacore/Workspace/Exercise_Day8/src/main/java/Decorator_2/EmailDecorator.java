package Decorator_2;

public abstract class EmailDecorator implements EmailSender {
    protected EmailSender wrappedSender;

    public EmailDecorator(EmailSender sender) {
        this.wrappedSender = sender;
    }

    @Override
    public void send(String message) {
        wrappedSender.send(message);
    }
}
