package Bai5;

public class Program {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.getNotification("email");
        if (notification1 != null)
            notification1.send();

        Notification notification2 = NotificationFactory.getNotification("sms");
        if (notification2 != null)
            notification2.send();

        Notification notification3 = NotificationFactory.getNotification("push");
        if (notification3 != null)
            notification3.send();

        Notification notification4 = NotificationFactory.getNotification("fax");
        if (notification4 != null)
            notification4.send();
        else System.out.println("Kênh thông báo không hợp lệ.");
    }
}
