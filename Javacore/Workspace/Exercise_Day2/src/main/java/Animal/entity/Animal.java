package Animal.entity;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void makeSound();
    public abstract void move();

    @Override
    public String toString() {
        return "Tên: " + this.getName() + ", Loài: " + this.getClass().getSimpleName();
    }

}
