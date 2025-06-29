import Course.CourseManagement;
import FlightBooking.FlightBookingManagement;
import Library.LibraryManagement;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagement library = new LibraryManagement();
        CourseManagement course = new CourseManagement();
        FlightBookingManagement flightBooking = new FlightBookingManagement();

        while (true) {
            System.out.println("===== MENU CHÍNH =====");
            System.out.println("1. Quản lý Thư viện");
            System.out.println("2. Quản lý Khóa học");
            System.out.println("3. Quản lý Đặt vé máy bay");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.showMenu();
                    break;
                case 2:
                    course.showMenu();
                    break;
                case 3:
                    flightBooking.showMenu();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}