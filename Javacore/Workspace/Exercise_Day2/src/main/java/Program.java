import Animal.AnimalManagement;
import Employee.EmployeeManagement;
import Student.StudentManagement;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // 4 đặc trưng của OOP
        // 1. Tính kế thừa - inheritance
        // 2. Tính đóng gói - encapsulation
        // 3. Tính trừu tượng - abstraction
        // 4. Tính đa hình - polymophysm
        Scanner sc = new Scanner(System.in);

        StudentManagement.data();
        EmployeeManagement.data();
        AnimalManagement.data();
        while (true) {
            System.out.println("\n===== QUẢN LÝ ĐỐI TƯỢNG =====");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Quản lý sở thú");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                case 1:
                    StudentManagement.showMenu();
                    break;
                case 2:
                    EmployeeManagement.showMenu();
                    break;
                case 3:
                    AnimalManagement.showMenu();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
