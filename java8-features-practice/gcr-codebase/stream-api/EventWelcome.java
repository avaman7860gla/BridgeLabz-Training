import java.util.*;

public class EventWelcome {
    public static void main(String[] args) {

        // list of attendees
        List<String> attendees = List.of("Rahul", "Raj", "Riya", "Neha");

        attendees.forEach(name->System.out.println("Welcome: " + name));
    }
}
