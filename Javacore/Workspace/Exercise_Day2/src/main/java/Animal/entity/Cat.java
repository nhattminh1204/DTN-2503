package Animal.entity;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " kêu: Meo meo!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " nhảy nhẹ nhàng.");
    }
}
