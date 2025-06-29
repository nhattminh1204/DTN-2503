package Decorator_2;

public class BasicEmailSender implements EmailSender {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
