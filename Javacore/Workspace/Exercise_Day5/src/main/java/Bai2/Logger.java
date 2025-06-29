package Bai2;

public class Logger {
    // Constructor private để ngăn tạo từ bên ngoài
    private Logger() {

    }

    // Inner static class chỉ được load khi gọi getInstance()
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    // Truy cập instance thông qua inner class (thread-safe, lazy loading)
    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
