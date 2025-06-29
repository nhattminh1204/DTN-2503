package Animal.entity;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " hót: Chip chip!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " bay trên trời.");
    }
}
