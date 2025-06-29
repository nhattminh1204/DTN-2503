package Decorator_1;

public class WithMilk extends CoffeeDecorator {
    public WithMilk(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", milk";
    }
}
