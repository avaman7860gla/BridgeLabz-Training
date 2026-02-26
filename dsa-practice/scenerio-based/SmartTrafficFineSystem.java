import java.util.*;

// Custom Exception
class InvalidVehicleException extends Exception {
    public InvalidVehicleException(String message) {
        super(message);
    }
}

abstract class Violation {
    protected String type;
    protected int baseFine;

    // Constructor
    public Violation(String type, int baseFine) {
        this.type = type;
        this.baseFine = baseFine;
    }

    // abstract method
    public abstract int calculateFine(int repeatCount);

    public String getType() {
        return type;
    }
}

// Normal violation
class StandardViolation extends Violation {
    public StandardViolation(String type, int baseFine) {
        super(type, baseFine);
    }

    @Override
    public int calculateFine(int repeatCount) {
        return baseFine;
    }
}

// Repeat offender violation
class RepeatViolation extends Violation {
    public RepeatViolation(String type, int baseFine) {
        super(type, baseFine);
    }

    @Override
    public int calculateFine(int repeatCount) {
        // extra fine
        return baseFine + (repeatCount * 200);
    }
}

class TrafficSystem {
    private Map<String, List<Violation>> violationMap = new HashMap<>();

    // Record violation
    public void recordViolation(String vehicleNumber, Violation violation) throws InvalidVehicleException {
        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new InvalidVehicleException("Invalid Vehicle Number!");
        }

        violationMap.putIfAbsent(vehicleNumber, new ArrayList<>());
        violationMap.get(vehicleNumber).add(violation);
    }

    // Generate monthly report
    public void generateReport() {
        System.out.println("Monthly Traffic Report:");
        for (Map.Entry<String, List<Violation>> entry : violationMap.entrySet()) {
            String vehicle = entry.getKey();
            List<Violation> violations = entry.getValue();

            int totalFine = 0;
            Map<String, Integer> typeCount = new HashMap<>();

            for (Violation v : violations) {
                typeCount.put(v.getType(), typeCount.getOrDefault(v.getType(), 0) + 1);
                int repeatCount = typeCount.get(v.getType()) - 1;
                totalFine += v.calculateFine(repeatCount);
            }

            System.out.println("Vehicle: " + vehicle);
            System.out.println("Violations: " + violations.size());
            System.out.println("Total Fine: ₹" + totalFine);
            System.println();
        }
    }
}

public class SmartTrafficFineSystem {
    public static void main(String[] args) {
        TrafficSystem system = new TrafficSystem();

        try {
            system.recordViolation("UP14AB1234", new StandardViolation("Signal Jump", 500));
            system.recordViolation("UP14AB1234", new RepeatViolation("Signal Jump", 500));
            system.recordViolation("UP16XY5678", new StandardViolation("Over Speeding", 1000));
            system.recordViolation("UP16XY5678", new RepeatViolation("Over Speeding", 1000));
            system.recordViolation("UP16XY5678", new RepeatViolation("Over Speeding", 1000));

            system.generateReport();
        } 
        catch (InvalidVehicleException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
