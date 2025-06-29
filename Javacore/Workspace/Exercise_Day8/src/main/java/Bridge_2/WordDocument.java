package Bridge_2;

public class WordDocument extends Document {
    public WordDocument(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void display() {
        renderer.render("Tài liệu Word");
    }
}
