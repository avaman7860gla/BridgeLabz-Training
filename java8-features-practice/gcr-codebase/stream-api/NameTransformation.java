import java.util.*;

public class NameTransformation {
    public static void main(String[] args) {

        // list of names
        List<String> names = List.of("aman", "rahul", "riya", "neha");

        // use streams
        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
