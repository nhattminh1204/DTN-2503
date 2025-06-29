package Bai5;

public class EmailNotification implements Notification{
    @Override
    public void send() {
        System.out.println("Gửi thông báo qua Email");
    }
}
