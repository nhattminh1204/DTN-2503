package Decorator;

public class BasicCoffee implements Coffee {

    @Override
    public double getCost() {
        return 15000;
    }

    @Override
    public String getDescription() {
        return "Cà phê đen";
    }
}
