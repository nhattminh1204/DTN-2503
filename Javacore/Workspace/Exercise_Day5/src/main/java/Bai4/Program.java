package Bai4;

public class Program {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("Circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("Square");
        shape2.draw();
    }
}
