package utils;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputEmail() {
        while (true) {
            String email = scanner.nextLine();
            if (email != null && email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                return email;
            }
            System.err.println("Email chưa đúng định dạng. Nhập lại!!!");
        }
    }

    public static String inputPassword() {
        while (true) {
            String password = scanner.nextLine();
            if (password.length() >= 6 && password.length() <= 12) {
                return password;
            } else {
                System.err.println("Mật khẩu phải từ 6-12 ký tự. Nhập lại!!!");
            }
        }
    }

    public static int inputMenu(int min, int max) {
        while (true) {
            int menu = scanner.nextInt();
            scanner.nextLine();
            if (menu >= min && menu <= max) {
                return menu;
            }
            System.err.println("Nhập vào trong khoảng giá trị "
                    + min + "-" + max);
        }
    }

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhập lại...");
            }
        }
    }

    public static String inputFullName() {
        while (true) {
            String fullName = scanner.nextLine();
            boolean isChecked = true;
            for (int i = 0; i < fullName.length(); i++) {
                char c = fullName.charAt(i);
                if (c != ' ' && !Character.isLetter(c)) {
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) return fullName;
            System.err.println("FullName chỉ chứa chữ, không chứa bất kỳ kí tự đặc biệt nào");
        }
    }
}
