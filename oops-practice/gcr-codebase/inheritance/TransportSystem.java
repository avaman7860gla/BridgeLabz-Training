// Base class
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Speed: " + maxSpeed + "km/h | Fuel: " + fuelType);
    }
}

// Car extends Vehicle
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType); // call parent constructor
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // reuse parent details
        System.out.println("Seats: " + seatCapacity);
    }
}

// Truck extends Vehicle
class Truck extends Vehicle {
    int loadCapacity;

    Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle extends Vehicle
class Motorcycle extends Vehicle {
    String type;

    Motorcycle(int maxSpeed, String fuelType, String type) {
        super(maxSpeed, fuelType);
        this.type = type;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        // Create different vehicles
        Car car = new Car(180, "Petrol", 5);
        Truck truck = new Truck(120, "Diesel", 10);
        Motorcycle bike = new Motorcycle(150, "Petrol", "Sports");

        // Display their information
        System.out.println("Car Details:");
        car.displayInfo();

        System.out.println("\nTruck Details:");
        truck.displayInfo();

        System.out.println("\nMotorcycle Details:");
        bike.displayInfo();

        // Polymorphism
        System.out.println("\nVehicle Parade:");

        Vehicle[] vehicles = {car, truck, bike};
        for (Vehicle v : vehicles) {
            v.displayInfo(); // calls the overridden method
            System.out.println();
        }
    }
}
