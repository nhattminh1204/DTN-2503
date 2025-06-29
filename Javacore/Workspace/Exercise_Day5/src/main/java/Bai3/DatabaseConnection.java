package Bai3;

public enum DatabaseConnection {
    INSTANCE;
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private boolean connected = false;

    public void connect() {
        if (!connected) {
            System.out.println("Connecting to database at " + url);
            connected = true;
        } else {
            System.out.println("Already connected to database");
        }
    }
    public boolean isConnected() {
        return connected;
    }
}
