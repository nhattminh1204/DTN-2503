package Library;

import Library.entity.Book;
import Library.entity.LoanRecord;
import Library.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<LoanRecord> loanRecords = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public LibraryManagement() {
        // Initialize sample data
        users.add(new User("U01", "Nguyễn Văn A"));
        users.add(new User("U02", "Trần Thị B"));
        users.add(new User("U03", "Lê Văn C"));

        books.add(new Book("B01", "Lập trình Java", "Nguyễn Nhật"));
        books.add(new Book("B02", "Học máy cơ bản", "Trần Hải"));
        books.add(new Book("B03", "Thiết kế web", "Lê Minh"));
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Hiển thị danh sách người dùng");
            System.out.println("3. Mượn sách");
            System.out.println("4. Trả sách");
            System.out.println("5. Hiển thị danh sách sách đang được mượn");
            System.out.println("6. Hiển thị danh sách sách đã được trả");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    showAllBooks();
                    break;
                case 2:
                    showAllUsers();
                    break;
                case 3:
                    handleBorrow();
                    break;
                case 4:
                    handleReturn();
                    break;
                case 5:
                    showBorrowedBooks();
                    break;
                case 6:
                    showReturnedBooks();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    private void showAllBooks() {
        System.out.println("Danh sách tất cả sách:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " (ID: " + book.getId() + "), Tác giả: " + book.getAuthor()
                    + ", Trạng thái: " + (book.isAvailable() ? "Có sẵn" : "Đang mượn"));
        }
    }

    private void showAllUsers() {
        System.out.println("Danh sách người dùng:");
        for (User user : users) {
            System.out.println("- Tên: " + user.getName() + " (ID: " + user.getId() + ")");
        }
    }

    private void handleBorrow() {
        System.out.print("Nhập ID người dùng: ");
        String userId = sc.nextLine();
        System.out.print("Nhập ID sách: ");
        String bookId = sc.nextLine();
        try {
            borrowBook(userId, bookId);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private void borrowBook(String userId, String bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);
        checkAvailable(book);

        book.setAvailable(false);
        LoanRecord loanRecord = new LoanRecord(user, book, LocalDate.now(), null);
        loanRecords.add(loanRecord);
        System.out.println(user.getName() + " đã mượn sách \"" + book.getTitle() + "\" thành công!");
    }

    private void handleReturn() {
        System.out.print("Nhập ID người dùng: ");
        String userId = sc.nextLine();
        System.out.print("Nhập ID sách: ");
        String bookId = sc.nextLine();
        try {
            returnBook(userId, bookId);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }


    private void returnBook(String userId, String bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        for (LoanRecord record : loanRecords) {
            if (record.getUser().getId().equals(userId)
                    && record.getBook().getId().equals(bookId)
                    && record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                record.getBook().setAvailable(true);
                System.out.println("Trả sách thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy thông tin mượn sách!");
    }

    private void showBorrowedBooks() {
        System.out.println("Danh sách sách đang được mượn:");
        boolean hasBorrowed = false;
        for (LoanRecord record : loanRecords) {
            if (record.getReturnDate() == null) {
                Book book = record.getBook();
                User user = record.getUser();
                System.out.println("- Sách: " + book.getTitle() + " (ID: " + book.getId() +
                        "), Tác giả: " + book.getAuthor() +
                        " | Người mượn: " + user.getName() + " (ID: " + user.getId() +
                        "), Ngày mượn: " + record.getLoanDate());
                hasBorrowed = true;
            }
        }
        if (!hasBorrowed) {
            System.out.println("Hiện không có sách nào đang được mượn.");
        }
    }

    private void showReturnedBooks() {
        System.out.println("Danh sách sách đã được trả:");
        boolean hasReturned = false;
        for (LoanRecord record : loanRecords) {
            if (record.getReturnDate() != null) {
                Book book = record.getBook();
                User user = record.getUser();
                System.out.println("- Sách: " + book.getTitle() + " (ID: " + book.getId() +
                        "), Tác giả: " + book.getAuthor() +
                        " | Người mượn: " + user.getName() + " (ID: " + user.getId() +
                        "), Ngày mượn: " + record.getLoanDate() +
                        ", Ngày trả: " + record.getReturnDate());
                hasReturned = true;
            }
        }
        if (!hasReturned) {
            System.out.println("Hiện không có sách nào đã được trả.");
        }
    }

    private User findUserById(String userId) {
        for (User user : users)
            if (user.getId().equals(userId))
                return user;
        throw new IllegalArgumentException("Người dùng không tồn tại!");
    }

    private Book findBookById(String bookId) {
        for (Book book : books)
            if (book.getId().equals(bookId))
                return book;
        throw new IllegalArgumentException("Sách không tồn tại!");
    }

    private void checkAvailable(Book book) {
        if (!book.isAvailable()) {
            throw new IllegalStateException("Sách không có sẵn để mượn!");
        }
    }
}