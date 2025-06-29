package Bridge_2;

public class MobileRenderer implements Renderer {
    @Override
    public void render(String content) {
        System.out.println("[Mobile] Hiển thị nội dung: " + content);
    }
}
