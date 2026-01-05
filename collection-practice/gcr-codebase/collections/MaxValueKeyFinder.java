import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) {

        // using map
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // traversal in map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println("Key with max value: " + maxKey);
    }
}