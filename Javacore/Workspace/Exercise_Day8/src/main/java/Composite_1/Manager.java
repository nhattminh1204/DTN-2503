package Composite_1;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Manager implements EmployeeComponent {
    private String name;
    private String position;
    private List<EmployeeComponent> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addSubordinate(EmployeeComponent e) {
        subordinates.add(e);
    }

    public void removeSubordinate(EmployeeComponent e) {
        subordinates.remove(e);
    }

    @Override
    public void showEmployeeDetails(int level) {
        System.out.println("  ".repeat(level) + "+ " + position + ": " + name);
        for (EmployeeComponent e : subordinates) {
            e.showEmployeeDetails(level + 1);
        }
    }
}

