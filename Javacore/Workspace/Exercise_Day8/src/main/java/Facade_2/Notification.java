package Facade_2;

public class Notification {
    public void sendEmail(String email, String message) {
        System.out.println("Gửi email đến " + email + ": " + message);
    }
}
