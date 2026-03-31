
import java.util.*;

public class SetEquality {

    // check sets are equal or not
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {

        // 2 set initialize
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // method call and display
        System.out.println("Sets are equal: " + areSetsEqual(set1, set2));
    }
}
