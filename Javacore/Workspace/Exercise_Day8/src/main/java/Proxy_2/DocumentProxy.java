package Proxy_2;

public class DocumentProxy implements Document {
    private final String fileName;
    private RealDocument realDocument;
    private final User user;

    public DocumentProxy(String fileName, User user) {
        this.fileName = fileName;
        this.user = user;
    }

    @Override
    public void read() {
        if (hasAccess()) {
            if (realDocument == null) {
                realDocument = new RealDocument(fileName);
            }
            realDocument.read();
        } else {
            System.out.println("❌ Người dùng " + user.getName() + " không có quyền truy cập file: " + fileName);
        }
    }

    private boolean hasAccess() {
        // Ví dụ: chỉ admin mới được đọc file nhạy cảm
        if (fileName.contains("confidential")) {
            return user.getRole().equals("admin");
        }
        return true; // các file khác đều được truy cập
    }
}
