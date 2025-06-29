package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.createVehicle("car");
        Vehicle bike = factory.createVehicle("bike");
        Vehicle truck = factory.createVehicle("truck");
        Vehicle plane = factory.createVehicle("plane");

        if (car != null)
            car.drive();
        if (bike != null)
            bike.drive();
        if (truck != null)
            truck.drive();
        if (plane != null)
            plane.drive();
    }
}
