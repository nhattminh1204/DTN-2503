package Proxy_2;

public class Program {
    public static void main(String[] args) {
        User admin = new User("Alice", "admin");
        User guest = new User("Bob", "guest");

        Document doc1 = new DocumentProxy("public_report.txt", guest);
        Document doc2 = new DocumentProxy("confidential_finance.pdf", guest);
        Document doc3 = new DocumentProxy("confidential_plan.pdf", admin);

        System.out.println("🔹 Bob (guest) đọc file công khai:");
        doc1.read();

        System.out.println("\n🔹 Bob (guest) đọc file bảo mật:");
        doc2.read();

        System.out.println("\n🔹 Alice (admin) đọc file bảo mật:");
        doc3.read();
    }
}
