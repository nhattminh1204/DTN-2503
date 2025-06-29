package Bai6;

public class Program {
    public static void main(String[] args) {

        ProductFactory.register("phone", Phone::new);
        ProductFactory.register("laptop", Laptop::new);

        Product p1 = ProductFactory.create("phone");
        p1.use();

        Product p2 = ProductFactory.create("laptop");
        p2.use();

        try {
            Product p3 = ProductFactory.create("tablet");
            p3.use();
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
