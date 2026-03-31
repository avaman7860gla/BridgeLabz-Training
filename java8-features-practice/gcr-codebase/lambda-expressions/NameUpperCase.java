import java.util.*;

public class NameUpperCase {
    public static void main(String[] args) {
        // list of employee names
        List<String> employeeNames = Arrays.asList("Rahul","Anita","Suresh","Priya","Amit");

        System.out.println("Employee Names for HR Letter:");

        // convert names to uppercase using String::toUpperCase
        employeeNames.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
