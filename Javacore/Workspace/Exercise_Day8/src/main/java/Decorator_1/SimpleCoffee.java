package Decorator_1;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 15000;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}
