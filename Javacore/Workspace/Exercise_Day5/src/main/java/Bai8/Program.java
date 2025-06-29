package Bai8;

public class Program {
    public static void main(String[] args) {
        GUIFactory factory;

        String os = "Mac"; // đổi thành "Windows" để test giao diện khác

        if (os.equalsIgnoreCase("Mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Application app = new Application(factory);
        app.renderUI();
    }
}
