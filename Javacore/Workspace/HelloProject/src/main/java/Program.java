import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Student[] arrayStudent = null;
        boolean isDataEntered = false;

        while (true) {
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. Hiển thị thông tin sinh viên");
            System.out.println("3. Sắp xếp sinh viên theo tuổi giảm dần");
            System.out.println("4. Sắp xếp sinh viên theo điểm tăng dần");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    arrayStudent = new Student[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh viên thứ " + (i + 1));
                        String id = "SV" + (i + 1);
                        System.out.print("Fullname: ");
                        String fullName = sc.nextLine();
                        System.out.print("Address: ");
                        String address = sc.nextLine();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Sex (true = Nam / false = Nữ): ");
                        boolean sex = sc.nextBoolean();
                        sc.nextLine();
                        System.out.print("Date of Birth (dd/MM/yyyy): ");
                        String dObStr = sc.nextLine();
                        Date dOb = sdf.parse(dObStr);

                        System.out.print("Grade: ");
                        float grade = sc.nextFloat();
                        sc.nextLine();

                        arrayStudent[i] = new Student(id, fullName, address, phone, email, sex, dOb, grade);
                    }

                    isDataEntered = true;
                    System.out.println("Đã nhập xong thông tin sinh viên.");
                    break;

                case 2:
                    if (!isDataEntered) {
                        System.out.println("Chưa có thông tin sinh viên nào.");
                    } else {
                        System.out.println("-----------------------Thông tin sinh viên-----------------------");
                        int i = 1;
                        for (Student s : arrayStudent) {
                            System.out.println("Sinh viên thứ " + i + ":");
                            i++;
                            s.display();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    if (!isDataEntered) {
                        System.out.println("Chưa có thông tin sinh viên nào để sắp xếp.");
                    } else {
                        System.out.println("Sắp xếp sinh viên theo tuổi giảm dần...");
                        Student[] sortedArray = arrayStudent.clone();
                        sortByAge(sortedArray);

                        int j = 1;
                        for (Student s : sortedArray) {
                            System.out.println("Sinh viên thứ " + j + ":");
                            j++;
                            s.display();
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    if (!isDataEntered) {
                        System.out.println("Chưa có thông tin sinh viên nào để sắp xếp.");
                    } else {
                        System.out.println("Sắp xếp sinh viên theo điểm tăng dần...");
                        Student[] sortedArrayByGrade = arrayStudent.clone();
                        sortByGrade(sortedArrayByGrade);

                        int j = 1;
                        for (Student s : sortedArrayByGrade) {
                            System.out.println("Sinh viên thứ " + j + ":");
                            j++;
                            s.display();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }

    public static void sortByAge(Student[] students) {
        Arrays.sort(students, (s1, s2) -> s2.getDateOfbirth().compareTo(s1.getDateOfbirth()));
    }

    public static void sortByGrade(Student[] students) {
        Arrays.sort(students, (s1, s2) -> Float.compare(s1.getGrade(), s2.getGrade()));
    }
}
