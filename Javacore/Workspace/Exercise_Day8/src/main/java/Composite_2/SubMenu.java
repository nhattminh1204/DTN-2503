package Composite_2;

import java.util.ArrayList;
import java.util.List;

public class SubMenu implements MenuComponent {
    private String name;
    private List<MenuComponent> children = new ArrayList<>();

    public SubMenu(String name) {
        this.name = name;
    }

    public void add(MenuComponent menuComponent) {
        children.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        children.remove(menuComponent);
    }

    @Override
    public void showMenu(int level) {
        System.out.println("  ".repeat(level) + "+ " + name);
        for (MenuComponent child : children) {
            child.showMenu(level + 1);
        }
    }
}
