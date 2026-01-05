import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {

        // map1
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // map2
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // merge both maps
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        // display merged map
        System.out.println("Merged Map: " + map1);
    }
}