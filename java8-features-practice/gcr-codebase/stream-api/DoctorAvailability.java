import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    // constructor
    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    // override toString method
    @Override
    public String toString() {
        return name + " - " + specialty;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {

        // list of doctors with speciality and availability
        List<Doctor> doctors = List.of(
                new Doctor("Dr. Raj", "Cardiology", true),
                new Doctor("Dr. Meera", "Neurology", false),
                new Doctor("Dr. Rahul", "Orthopedic", true),
                new Doctor("Dr. Neha", "Dermatology", true)
        );

        doctors.stream()
                .filter(d -> d.availableOnWeekend)
                .sorted(Comparator.comparing(d -> d.specialty))
                .forEach(System.out::println);
    }
}
