package Composite_2;

public class MenuItem implements MenuComponent {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public void showMenu(int level) {
        System.out.println("  ".repeat(level) + "- " + name);
    }
}
