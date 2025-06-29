package Flyweight_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        List<SoldierPosition> battlefield = new ArrayList<>();
        Random random = new Random();

        // Flyweight dùng chung
        Soldier boBinh = SoldierFactory.getSoldier("Súng AK", "Quân phục xanh");
        Soldier banTia = SoldierFactory.getSoldier("Súng ngắm", "Ngụy trang");
        Soldier linhDacNhiem = SoldierFactory.getSoldier("Tiểu liên", "Giáp đen");

        // Giới hạn số lượng cho dễ đọc
        int soBoBinh = 5;
        int soBanTia = 3;
        int soDacNhiem = 2;

        // Tạo lính bộ binh
        for (int i = 0; i < soBoBinh; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            battlefield.add(new SoldierPosition(x, y, boBinh));
        }

        // Tạo lính bắn tỉa
        for (int i = 0; i < soBanTia; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            battlefield.add(new SoldierPosition(x, y, banTia));
        }

        // Tạo lính đặc nhiệm
        for (int i = 0; i < soDacNhiem; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            battlefield.add(new SoldierPosition(x, y, linhDacNhiem));
        }

        // In ra toàn bộ lính
        System.out.println("📌 Danh sách lính trên chiến trường:");
        for (SoldierPosition soldier : battlefield) {
            soldier.render();
        }
    }
}
