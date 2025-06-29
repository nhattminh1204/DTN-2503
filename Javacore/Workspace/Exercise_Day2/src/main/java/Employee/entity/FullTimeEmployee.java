package Employee.entity;

public class FullTimeEmployee extends Employee{
    private double fixedSalary;

    public FullTimeEmployee(String id, String name, double fixedSalary) {
        super(id, name, fixedSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getSalary();
    }

    @Override
    public String toString() {
        return super.toString() + ", Lương: " + calculateSalary();
    }

}
