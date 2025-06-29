package Facade;

public class EmailService {
    public void sendConfirmation(String email) {
        System.out.println("Đã gửi email xác nhận đến: " + email);
    }
}
