package Bai3;

public class Program {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.INSTANCE;
        DatabaseConnection conn2 = DatabaseConnection.INSTANCE;

        conn1.connect();
        System.out.println("Đã kết nối? " + conn1.isConnected() + "\n");

        conn2.connect();
        System.out.println("Đã kết nối? " + conn2.isConnected() + "\n");

        System.out.println("conn1 == conn2 ? " + (conn1 == conn2));
    }
}
