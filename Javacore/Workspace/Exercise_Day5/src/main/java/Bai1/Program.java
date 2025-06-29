package Bai1;

public class Program {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        System.out.println("App Name: " + config.getAppName());
        System.out.println("Version: " + config.getVersion());

        config.setAppName("BTI App");
        System.out.println("New App Name: " + AppConfig.getInstance().getAppName());
    }
}
