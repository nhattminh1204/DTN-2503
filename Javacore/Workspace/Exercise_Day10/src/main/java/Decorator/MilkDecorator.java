package Decorator;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", thêm sữa";
    }
}
