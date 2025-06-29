package Decorator;

public class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 8000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", thêm caramel";
    }
}
