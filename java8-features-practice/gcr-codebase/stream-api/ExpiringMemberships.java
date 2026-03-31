import java.time.*;
import java.util.*;

class GymMember {
    String name;
    LocalDate expiryDate;

    // constructor
    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    // overrite toString method
    @Override
    public String toString() {
        return name + " , Expires on: " + expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {

        // list of members
        List<GymMember> members = List.of(
                new GymMember("Rahul", LocalDate.now().plusDays(10)),
                new GymMember("Anita", LocalDate.now().plusDays(40)),
                new GymMember("Karan", LocalDate.now().plusDays(25))
        );

        // use local date
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        // use streams
        members.stream()
                .filter(m -> !m.expiryDate.isAfter(next30Days))
                .forEach(System.out::println);
    }
}
