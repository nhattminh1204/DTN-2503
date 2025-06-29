package Proxy_1;

public class Program {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("cat.png");
        Image img2 = new ProxyImage("dog.png");

        System.out.println("Ảnh chưa hiển thị, chưa load:");
        System.out.println("------");

        System.out.println("\nNgười dùng xem ảnh mèo:");
        img1.display(); // chỉ bây giờ mới load

        System.out.println("\nNgười dùng xem lại ảnh mèo:");
        img1.display(); // không load lại

        System.out.println("\nNgười dùng xem ảnh chó:");
        img2.display(); // giờ mới load ảnh chó
    }
}
