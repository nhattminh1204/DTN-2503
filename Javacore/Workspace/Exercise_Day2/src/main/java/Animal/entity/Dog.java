package Animal.entity;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " sủa: Gâu gâu!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " chạy bằng 4 chân.");
    }
}
