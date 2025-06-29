package Singleton;

public class Logger {
    private static volatile Logger instance; // đảm bảo rằng các thread luôn nhìn thấy giá trị mới nhất của instance

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

