package Bai2;

public class Program {
    public static void main(String[] args) {
        Runnable task = () -> {
            Logger logger = Logger.getInstance();
            logger.log("Thread " + Thread.currentThread().getName() + " đang ghi log");
        };

        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(task, "T" + i);
            thread.start();
        }
    }
}
