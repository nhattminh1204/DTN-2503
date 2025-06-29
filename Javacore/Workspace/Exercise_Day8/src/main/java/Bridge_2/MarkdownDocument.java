package Bridge_2;

public class MarkdownDocument extends Document {
    public MarkdownDocument(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void display() {
        renderer.render("Tài liệu Markdown");
    }
}
