package Decorator;

public class Main {
    public static void main(String[] args) {

        Coffee coffee1 = new BasicCoffee();
        show(coffee1);

        Coffee coffee2 = new MilkDecorator(new BasicCoffee());
        show(coffee2);

        Coffee coffee3 = new SugarDecorator(new CaramelDecorator(new BasicCoffee()));
        show(coffee3);

        Coffee coffee4 = new SugarDecorator(new CaramelDecorator(new MilkDecorator(new BasicCoffee())));
        show(coffee4);

        Coffee coffee5 = new SugarDecorator(new CaramelDecorator(new MilkDecorator(new BasicCoffee())));
        show(coffee4);
    }

    public static void show(Coffee coffee) {
        System.out.println(coffee.getDescription() + " | Giá: " + coffee.getCost());
    }
}
