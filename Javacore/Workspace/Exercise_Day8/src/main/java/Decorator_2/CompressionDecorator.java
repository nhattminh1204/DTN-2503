package Decorator_2;

public class CompressionDecorator extends EmailDecorator {
    public CompressionDecorator(EmailSender sender) {
        super(sender);
    }

    private String compress(String message) {
        return "[Compressed] " + message;
    }

    @Override
    public void send(String message) {
        String compressed = compress(message);
        super.send(compressed);
    }
}
