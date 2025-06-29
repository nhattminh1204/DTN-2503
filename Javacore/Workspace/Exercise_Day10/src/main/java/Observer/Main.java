package Observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer user1 = new Subscriber("Nguyễn Văn A");
        Observer user2 = new Subscriber("Trần Thị B");
        Observer user3 = new Subscriber("Lê Văn C");

        agency.registerObserver(user1);
        agency.registerObserver(user2);

        agency.publishNews("Việt Nam vô địch AFF Cup 2025!");
        agency.publishNews("Giá xăng giảm mạnh từ ngày mai.");

        agency.removeObserver(user1);
        agency.registerObserver(user3);

        agency.publishNews("Nhiệt độ miền Trung sắp đạt 40 độ C.");
    }
}
