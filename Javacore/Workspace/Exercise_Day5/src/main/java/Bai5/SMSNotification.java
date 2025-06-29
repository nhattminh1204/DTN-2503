package Bai5;

public class SMSNotification implements Notification{
    @Override
    public void send() {
        System.out.println("Gửi thông báo qua SMS");
    }
}
