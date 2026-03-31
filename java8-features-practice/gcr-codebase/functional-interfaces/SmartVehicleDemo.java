interface Vehicle {
    void displaySpeed();

    // New feature only for vehicles that support it
    default void displayBatteryStatus() {
        System.out.println("Battery status not applicable for this vehicle");
    }
}

// Car
class Car implements Vehicle {
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }
}

// Electric car
class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Electric Car speed: 70 km/h");
    }

    public void displayBatteryStatus() {
        System.out.println("Battery level: 85%");
    }
}

public class SmartVehicleDemo {
    public static void main(String[] args) {

        Vehicle petrolCar = new Car();
        Vehicle electricCar = new ElectricCar();

        petrolCar.displaySpeed();
        petrolCar.displayBatteryStatus();

        electricCar.displaySpeed();
        electricCar.displayBatteryStatus();
    }
}
