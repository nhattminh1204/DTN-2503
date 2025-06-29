package Bridge_2;

public class PDFDocument extends Document {
    public PDFDocument(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void display() {
        renderer.render("Tài liệu PDF");
    }
}
