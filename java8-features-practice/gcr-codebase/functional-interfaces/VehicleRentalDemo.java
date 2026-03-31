// Interface
interface RentalVehicle {
    void rent();
    void returnVehicle();
}

// Car class
class Car implements RentalVehicle {
    public void rent() {
        System.out.println("Car rented");
    }

    public void returnVehicle() {
        System.out.println("Car returned");
    }
}

// Bike class
class Bike implements RentalVehicle {
    public void rent() {
        System.out.println("Bike rented");
    }

    public void returnVehicle() {
        System.out.println("Bike returned");
    }
}

// Bus class
class Bus implements RentalVehicle {
    public void rent() {
        System.out.println("Bus rented");
    }

    public void returnVehicle() {
        System.out.println("Bus returned");
    }
}

public class VehicleRentalDemo {
    public static void main(String[] args) {
        RentalVehicle car = new Car();
        RentalVehicle bike = new Bike();
        RentalVehicle bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}
