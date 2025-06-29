package AbstractFactory;

public class DarkTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering dark-themed text field ...");
    }
}
