package Student;

import Student.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void showMenu() {
        while (true) {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Danh sách sinh viên");
            System.out.println("3. Danh sách sinh viên (GPA >= 3.2)");
            System.out.println("4. Danh sách sinh viên (GPA giảm dần)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    displayHighGpaStudents();
                    break;
                case 4:
                    displaySortedByGpa();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public static void data() {
        students.add(new Student("SV01", "Nguyễn Văn Minh", 20, 3.5));
        students.add(new Student("SV02", "Trần Thị Hương", 21, 2.8));
        students.add(new Student("SV03", "Lê Hoàng Nam", 19, 3.9));
        students.add(new Student("SV04", "Phạm Thị Mai", 22, 3.1));
        students.add(new Student("SV05", "Hoàng Anh Duy", 20, 3.6));
        students.add(new Student("SV06", "Vũ Thị Lan", 21, 2.5));
        students.add(new Student("SV07", "Đặng Quang Huy", 19, 3.3));
        students.add(new Student("SV08", "Ngô Thị Thu", 22, 3.0));
        students.add(new Student("SV09", "Bùi Văn Khánh", 20, 3.7));
        students.add(new Student("SV10", "Phan Thị Ngọc", 21, 3.4));
    }

    public static void addStudent() {
        System.out.println("Nhập thông tin sinh viên");

        String id;
        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();

            boolean exists = false;
            for (Student s : students) {
                if (s.getId().equals(id)) {
                    exists = true;
                    break;
                }
            }

            if (exists)
                System.out.println("ID đã tồn tại! Vui lòng nhập ID khác.");
            else
                break;
        }

        System.out.print("Họ và tên: ");
        String name = sc.nextLine();
        System.out.print("Tuổi: ");
        int age = sc.nextInt();
        sc.nextLine();
        double gpa;
        while (true) {
            System.out.print("GPA: ");
            gpa = Double.parseDouble(sc.nextLine());

            if (gpa < 0.0 || gpa > 4.0) {
                System.out.println("GPA không hợp lệ! Vui lòng nhập lại");
            } else {
                break;
            }
        }

        students.add(new Student(id, name, age, gpa));
        System.out.println("Thêm sinh viên thành công!");
    }

    public static void displayAllStudents() {
        System.out.println("Danh sách sinh viên");
        for (Student s : students) {
            System.out.println( s);
        }
    }

    public static void displayHighGpaStudents() {
        System.out.println("Danh sách sinh viên có GPA từ 3.2");
        for (Student s : students) {
            if (s.getGpa() >= 3.2)
                System.out.println( s);
        }
    }

    public static void displaySortedByGpa() {
        System.out.println("Danh sách sinh viên (GPA↓)");
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .forEach(System.out::println);
    }
}
