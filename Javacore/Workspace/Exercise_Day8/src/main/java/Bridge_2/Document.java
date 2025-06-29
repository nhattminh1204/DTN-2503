package Bridge_2;

public abstract class Document {
    protected Renderer renderer;

    public Document(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void display();
}
