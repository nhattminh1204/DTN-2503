package Decorator_1;

public class WithSugar extends CoffeeDecorator {
    public WithSugar(Coffee c) {
        super(c);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2500;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", sugar";
    }
}
