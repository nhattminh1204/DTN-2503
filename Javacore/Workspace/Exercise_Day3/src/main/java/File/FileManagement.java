package File;

import File.entity.*;

import java.io.IOException;
import java.util.Scanner;

public class FileManagement {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== TRÌNH QUẢN LÝ FILE =====");
            System.out.println("1. Làm việc với file text");
            System.out.println("2. Làm việc với file ảnh");
            System.out.println("3. Làm việc với file video");
            System.out.println("4. Thoát");
            System.out.print("Chọn loại file (1-4): ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) break;

            System.out.print("Nhập đường dẫn file: ");
            String filePath = sc.nextLine();

            FileHandler fileHandler = null;
            switch (choice) {
                case 1:
                    fileHandler = new TextFileHandler(filePath);
                    break;
                case 2:
                    fileHandler = new ImageFileHandler(filePath);
                    break;
                case 3:
                    fileHandler = new VideoFileHandler(filePath);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
            }

            handleFileOperations(sc, fileHandler);
        }

        sc.close();
        System.out.println("Kết thúc chương trình!");
    }

    public static void handleFileOperations(Scanner sc, FileHandler fileHandler) throws IOException {
        while (true) {
            System.out.println("\n===== THAO TÁC VỚI FILE =====");
            System.out.println("1. Đọc file");
            System.out.println("2. Ghi file");
            System.out.println("3. Xóa file");

            if (fileHandler instanceof Compressible) {
                System.out.println("4. Nén file");
                System.out.println("5. Giải nén file");
            }
            if (fileHandler instanceof Encryptable) {
                System.out.println("6. Mã hóa file");
                System.out.println("7. Giải mã file");
            }

            System.out.println("8. Quay lại");
            System.out.print("Chọn thao tác: ");

            int operation = sc.nextInt();
            sc.nextLine();

            if (operation == 8)
                    break;

            switch (operation) {
                case 1:
                    fileHandler.read();
                    break;
                case 2:
                    System.out.print("Nhập nội dung: ");
                    String content = sc.nextLine();
                    fileHandler.write(content);
                    break;
                case 3:
                    fileHandler.delete();
                    break;
                case 4:
                    if (fileHandler instanceof Compressible) {
                        System.out.print("Nhập đường dẫn đầu ra: ");
                        String outputPath = sc.nextLine();
                        ((Compressible) fileHandler).compress(outputPath);
                    }
                    break;
                case 5:
                    if (fileHandler instanceof Compressible) {
                        System.out.print("Nhập đường dẫn đầu ra: ");
                        String outputPath = sc.nextLine();
                        ((Compressible) fileHandler).decompress(outputPath);
                    }
                    break;
                case 6:
                    if (fileHandler instanceof Encryptable) {
                        System.out.print("Nhập khóa mã hóa: ");
                        String key = sc.nextLine();
                        ((Encryptable) fileHandler).encrypt(key);
                    }
                    break;
                case 7:
                    if (fileHandler instanceof Encryptable) {
                        System.out.print("Nhập khóa giải mã: ");
                        String key = sc.nextLine();
                        ((Encryptable) fileHandler).decrypt(key);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
