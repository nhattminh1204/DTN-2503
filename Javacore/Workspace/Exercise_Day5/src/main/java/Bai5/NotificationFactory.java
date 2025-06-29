package Bai5;

public class NotificationFactory {
    public static Notification getNotification(String channel) {
        if (channel == null) {
            return null;
        }
        switch (channel.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                System.out.println("Không hỗ trợ kênh: " + channel);
                return null;
        }
    }
}
