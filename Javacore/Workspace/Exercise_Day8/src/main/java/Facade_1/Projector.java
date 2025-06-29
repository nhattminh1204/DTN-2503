package Facade_1;

public class Projector {
    public void on() {
        System.out.println("Projector ON");
    }

    public void setInput(String source) {
        System.out.println("Projector input set to: " + source);
    }

    public void off() {
        System.out.println("Projector OFF");
    }
}
