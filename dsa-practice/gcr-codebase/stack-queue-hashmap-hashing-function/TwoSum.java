import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public static int[] findIndices(int[] arr, int target) {
        // Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // If complement exists return indices
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current value with its index
            map.put(arr[i], i);
        }

        // If no pair found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = findIndices(arr, target);
        
        System.out.println("Indices found: " + Arrays.toString(result));
    }
}
