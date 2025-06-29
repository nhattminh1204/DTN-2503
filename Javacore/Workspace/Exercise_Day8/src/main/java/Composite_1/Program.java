package Composite_1;

public class Program {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Nam", "Nhân viên kế toán");
        Employee emp2 = new Employee("Lan", "Nhân viên kế toán");
        Employee emp3 = new Employee("Hoàng", "Nhân viên marketing");
        Employee emp4 = new Employee("Mai", "Nhân viên marketing");
        Employee emp5 = new Employee("Huy", "Nhân viên IT");
        Employee emp6 = new Employee("An", "Nhân viên IT");

        // Quản lý các phòng ban
        Manager manager1 = new Manager("Minh", "Quản lý phòng Kế toán");
        manager1.addSubordinate(emp1);
        manager1.addSubordinate(emp2);

        Manager manager2 = new Manager("Hạnh", "Quản lý phòng Marketing");
        manager2.addSubordinate(emp3);
        manager2.addSubordinate(emp4);

        Manager manager3 = new Manager("Dũng", "Quản lý phòng IT");
        manager3.addSubordinate(emp5);
        manager3.addSubordinate(emp6);

        // Giám đốc tổng
        Manager generalManager = new Manager("Tuấn", "Giám đốc");
        generalManager.addSubordinate(manager1);
        generalManager.addSubordinate(manager2);
        generalManager.addSubordinate(manager3);

        // Hiển thị sơ đồ công ty
        generalManager.showEmployeeDetails(0);
    }
}
