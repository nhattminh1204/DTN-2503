package Composite_1;

public class Employee implements EmployeeComponent {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails(int level) {
        System.out.println("  ".repeat(level) + "- " + position + ": " + name);
    }
}

