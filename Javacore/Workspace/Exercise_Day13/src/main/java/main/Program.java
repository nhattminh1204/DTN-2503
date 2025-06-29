package main;

import daos.UserDAOImpl;
import models.User;
import service.UserService;
import service.UserServiceImpl;
import utils.DatabaseUtil;

import jakarta.validation.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.*;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static void main(String[] args) {
        Connection conn = DatabaseUtil.getConnection();
        UserService userService = new UserServiceImpl(new UserDAOImpl(conn));

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> register(userService);
                case 2 -> login(userService);
                case 3 -> search(userService);
                case 4 -> changePassword(userService);
                case 5 -> showAllUsers(userService);
                case 6 -> deleteUser(userService);
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Đăng ký");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Tìm kiếm người dùng");
        System.out.println("4. Đổi mật khẩu");
        System.out.println("5. Danh sách người dùng");
        System.out.println("6. Xóa người dùng");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
    }

    private static void register(UserService service) {
        System.out.println("=== Đăng ký người dùng mới ===");
        User user = new User();
        System.out.print("Họ tên: ");
        user.setFullName(scanner.nextLine());
        System.out.print("Email: ");
        user.setEmail(scanner.nextLine());
        System.out.print("Mật khẩu: ");
        user.setPassword(scanner.nextLine());
        System.out.print("Số điện thoại: ");
        user.setPhone(scanner.nextLine());
        System.out.print("Địa chỉ: ");
        user.setAddress(scanner.nextLine());
        System.out.print("Ngày sinh (yyyy-MM-dd): ");
        user.setBirthDay(LocalDate.parse(scanner.nextLine()));
        System.out.print("Vai trò (user/admin): ");
        user.setRole(scanner.nextLine());

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<User> v : violations) {
                System.out.println("❌ " + v.getMessage());
            }
            return;
        }

        if (service.register(user)) {
            System.out.println("✅ Đăng ký thành công!");
        } else {
            System.out.println("❌ Email đã tồn tại.");
        }
    }

    private static void login(UserService service) {
        System.out.println("=== Đăng nhập ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();

        User user = service.login(email, password);
        if (user != null) {
            System.out.println("✅ Đăng nhập thành công! Xin chào, " + user.getFullName());
        } else {
            System.out.println("❌ Sai email hoặc mật khẩu.");
        }
    }

    private static void search(UserService service) {
        System.out.print("Nhập tên hoặc email để tìm: ");
        String keyword = scanner.nextLine();
        List<User> result = service.searchUser(keyword);
        if (result.isEmpty()) {
            System.out.println("❌ Không tìm thấy người dùng nào.");
        } else {
            System.out.println("🔍 Kết quả tìm kiếm:");
            result.forEach(u -> System.out.println(u.getFullName() + " - " + u.getEmail()));
        }
    }

    private static void changePassword(UserService service) {
        System.out.println("=== Đổi mật khẩu ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mật khẩu cũ: ");
        String oldPass = scanner.nextLine();
        System.out.print("Mật khẩu mới: ");
        String newPass = scanner.nextLine();

        if (service.changePassword(email, oldPass, newPass)) {
            System.out.println("✅ Đổi mật khẩu thành công.");
        } else {
            System.out.println("❌ Đổi mật khẩu thất bại. Kiểm tra thông tin.");
        }
    }

    private static void showAllUsers(UserService service) {
        System.out.println("=== Danh sách người dùng ===");
        List<User> users = service.getAllUsers();
        for (User u : users) {
            System.out.printf("- %s (%s)\n", u.getFullName(), u.getEmail());
        }
    }

    private static void deleteUser(UserService service) {
        System.out.print("Nhập email để xóa: ");
        String email = scanner.nextLine();
        if (service.deleteUser(email)) {
            System.out.println("✅ Đã xóa người dùng.");
        } else {
            System.out.println("❌ Không tìm thấy email.");
        }
    }
}
