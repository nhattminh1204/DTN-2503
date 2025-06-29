package Decorator_2;

public class Program {
    public static void main(String[] args) {
        // Gửi email bình thường
        EmailSender simpleEmail = new BasicEmailSender();
        simpleEmail.send("Hello user");

        System.out.println();

        // Gửi email đã mã hóa
        EmailSender encryptedEmail = new EncryptionDecorator(new BasicEmailSender());
        encryptedEmail.send("Hello user");

        System.out.println();

        // Gửi email đã mã hóa và ký
        EmailSender secureEmail = new SignatureDecorator(
                new EncryptionDecorator(
                        new BasicEmailSender()));
        secureEmail.send("Hello user");

        System.out.println();

        // Gửi email nén, mã hóa và ký
        EmailSender fullEmail = new SignatureDecorator(
                new EncryptionDecorator(
                        new CompressionDecorator(
                                new BasicEmailSender())));
        fullEmail.send("Hello user");
    }
}
