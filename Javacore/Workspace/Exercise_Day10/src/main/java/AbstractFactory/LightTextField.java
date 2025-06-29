package AbstractFactory;

public class LightTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering light-themed text field ...");
    }
}
