package Bai1;

public class AppConfig {
    private static AppConfig instance;

    private String appName = "My Application";
    private String version = "1.0.0";

    private AppConfig() {

    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public static void setInstance(AppConfig instance) {
        AppConfig.instance = instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
