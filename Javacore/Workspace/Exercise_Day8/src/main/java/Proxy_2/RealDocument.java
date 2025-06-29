package Proxy_2;

public class RealDocument implements Document {
    private final String fileName;

    public RealDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void read() {
        System.out.println("📖 Đang đọc nội dung file: " + fileName);
    }
}
