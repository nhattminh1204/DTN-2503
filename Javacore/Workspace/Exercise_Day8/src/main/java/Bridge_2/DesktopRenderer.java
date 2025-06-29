package Bridge_2;

public class DesktopRenderer implements Renderer {
    @Override
    public void render(String content) {
        System.out.println("[Desktop] Hiển thị nội dung: " + content);
    }
}
