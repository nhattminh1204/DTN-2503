package FactoryMethod;

public class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if (type == null)
            return null;

        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "truck":
                return new Truck();
            default:
                System.out.println("Không xác định loại phương tiện: " + type + "!");
                return null;
        }
    }
}
