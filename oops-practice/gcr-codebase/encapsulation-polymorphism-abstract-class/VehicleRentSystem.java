// abstract base class 
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    // constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // getters
    public String getVehicleNumber() { 
        return vehicleNumber; 
    }
    public String getType() { 
        return type; 
    }
    public double getRentalRate() { 
        return rentalRate; 
    }
    protected String getInsurancePolicyNumber() { 
        return insurancePolicyNumber; 
    }

    // abstract method 
    public abstract double calculateRentalCost(int days);
}

// interface 
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class extends Vehicle and implements Insurable
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber); // call parent constructor
    }

    // implement abstract method
    public double calculateRentalCost(int days) { return getRentalRate() * days; }

    // implement methods
    public double calculateInsurance() { return 2000; }
    public String getInsuranceDetails() { return "Car Insurance = Policy " + getInsurancePolicyNumber(); }
}

// bike class extends Vehicle and implements Insurable
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    // rental cost with 20% discount for bikes
    public double calculateRentalCost(int days) { 
        return getRentalRate() * days * 0.8; 
    }

    public double calculateInsurance() { 
        return 500; 
    }
    public String getInsuranceDetails() { 
        return "Bike Insurance: Policy " + getInsurancePolicyNumber(); 
    }
}

// truck class extends vehicle and implements insurable
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    // Rental cost with 50% extra charge for trucks
    public double calculateRentalCost(int days) { 
        return getRentalRate() * days * 1.5; 
    }

    public double calculateInsurance() { 
        return 3000; 
    }
    public String getInsuranceDetails() { 
        return "Truck Insurance: Policy " + getInsurancePolicyNumber(); 
    }
}

// Utility class
class VehicleRentalSystem {
    public static void processVehicles(Vehicle[] vehicles, int days) {
        for (Vehicle v : vehicles) {
            // Display rental cost
            System.out.println(v.getType() + " Rental Cost: " + v.calculateRentalCost(days));

            // If vehicle is insurable, display insurance details
            if (v instanceof Insurable) {
                System.out.println(((Insurable)v).getInsuranceDetails() + 
                                   " Insurance Cost = " + ((Insurable)v).calculateInsurance());
            }
        }
    }
}


public class VehicleRentSystem {
    public static void main(String[] args) {
        // Create different types of vehicles
        Vehicle[] vehicles = {
            new Car("C123", 1000, "P1001"),
            new Bike("B456", 300, "P2002"),
            new Truck("T789", 2000, "P3003")
        };

        // Display rental and insurance details
        System.out.println("Vehicle Rental System:");
        VehicleRentalSystem.processVehicles(vehicles, 5);
    }
}
