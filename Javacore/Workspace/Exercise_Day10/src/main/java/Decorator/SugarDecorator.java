package Decorator;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", thêm đường";
    }
}
