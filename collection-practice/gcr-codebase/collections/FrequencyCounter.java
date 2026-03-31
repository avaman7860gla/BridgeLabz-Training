import java.util.*;

public class FrequencyCounter {
    // count frequency of ech item in list
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {

        // input list
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        // method call
        Map<String, Integer> result = countFrequency(words);

        // display frequency
        System.out.println("Frequency: " + result);
    }
}
