package Proxy_1;

public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("📂 Đang tải ảnh từ đĩa: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("🖼️ Hiển thị ảnh: " + fileName);
    }
}
