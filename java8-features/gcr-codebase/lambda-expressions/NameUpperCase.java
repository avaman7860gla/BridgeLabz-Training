// EmployeeNameUppercase.java
// Converts employee names to uppercase using stream and method reference

import java.util.*;

public class NameUpperCase {

    public static void main(String[] args) {

        // List of employee names
        List<String> employeeNames = Arrays.asList(
                "Rahul",
                "Anita",
                "Suresh",
                "Priya",
                "Amit"
        );

        System.out.println("---- Employee Names for HR Letter ----");

        // Convert names to uppercase using String::toUpperCase
        employeeNames.stream()
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
    }
}
