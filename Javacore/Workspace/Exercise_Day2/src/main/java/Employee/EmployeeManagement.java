package Employee;

import Employee.entity.Employee;
import Employee.entity.FullTimeEmployee;
import Employee.entity.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    static Scanner sc = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();
    static List<FullTimeEmployee> fullTimeEmployees = new ArrayList<>();
    static List<PartTimeEmployee> partTimeEmployees = new ArrayList<>();

    public static void showMenu() {

        while (true) {
            System.out.println("\n===== QUẢN LÝ NHÂN VIÊN =====");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Danh sách nhân viên toàn thời gian");
            System.out.println("3. Danh sách nhân viên bán thời gian");
            System.out.println("4. Tính tổng lương phải trả");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    displayFullTimeEmployees();
                    break;
                case 3:
                    displayPartTimeEmployees();
                    break;
                case 4:
                    calculateTotalSalary();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    public static void data() {
        employees.add(new FullTimeEmployee("FT001", "Nguyễn Văn An", 12000));
        employees.add(new FullTimeEmployee("FT002", "Trần Thị Bình", 15000));
        employees.add(new FullTimeEmployee("FT003", "Lê Thị Cẩm", 18000));
        employees.add(new FullTimeEmployee("FT004", "Phạm Minh Dũng", 16000));
        employees.add(new FullTimeEmployee("FT005", "Hoàng Thị Hà", 14000));
        employees.add(new FullTimeEmployee("FT006", "Nguyễn Thị Mai", 13000));
        employees.add(new FullTimeEmployee("FT007", "Bùi Hoàng Giang", 20000));
        employees.add(new FullTimeEmployee("FT008", "Trương Thị Lan", 17000));
        employees.add(new FullTimeEmployee("FT009", "Võ Minh Hòa", 19000));
        employees.add(new FullTimeEmployee("FT010", "Đỗ Thị Kim", 21000));

        employees.add(new PartTimeEmployee("PT001", "Nguyễn Minh Khang", 100, 150));
        employees.add(new PartTimeEmployee("PT002", "Trần Thi Lý", 120, 120));
        employees.add(new PartTimeEmployee("PT003", "Lê Thanh Mai", 90, 140));
        employees.add(new PartTimeEmployee("PT004", "Phạm Ngọc Nhi", 110, 130));
        employees.add(new PartTimeEmployee("PT005", "Hoàng Minh Ông", 80, 160));
        employees.add(new PartTimeEmployee("PT006", "Nguyễn Thị Phương", 95, 170));
        employees.add(new PartTimeEmployee("PT007", "Bùi Thị Quỳnh", 85, 180));
        employees.add(new PartTimeEmployee("PT008", "Trương Minh Quân", 75, 190));
        employees.add(new PartTimeEmployee("PT009", "Võ Ngọc Sơn", 110, 140));
        employees.add(new PartTimeEmployee("PT010", "Đỗ Minh Tấn", 120, 150));
    }

    public static void displayAllEmployees() {
        System.out.println("Danh sách nhân viên");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void displayFullTimeEmployees() {
        System.out.println("Danh sách nhân viên toàn thời gian");
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee)
                System.out.println(e);
        }
    }

    public static void displayPartTimeEmployees() {
        System.out.println("Danh sách nhân viên bán thời gian");
        for (Employee e : employees) {
            if (e instanceof PartTimeEmployee)
                System.out.println(e);
        }
    }

    public static void calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee e : employees)
            totalSalary += e.getSalary();
        System.out.println("Tổng lương công ty phải trả: " + totalSalary);
    }
}
