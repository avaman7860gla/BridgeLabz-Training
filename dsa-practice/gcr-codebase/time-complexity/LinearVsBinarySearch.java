
import java.util.*;

public class LinearVsBinarySearch {
   
    // linear search 
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) 
                return i;
        }
        return -1;
    }

    // binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) 
                return mid;
            if (arr[mid] < target) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return -1;
    }

   
    public static int[] generateArray(int n, int bound) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(bound);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1;
        for (int n : sizes) {
            int[] arr = generateArray(n, n * 2);
            long start, end;

            // complexity of linear search
            start = System.nanoTime();  // start time
            linearSearch(arr, target);
            end = System.nanoTime();   // end time
            System.out.printf("Linear Search for N=%d : %.4f ms\n", n, (end - start) / 1e6);

            // complexity of binary search
            Arrays.sort(arr);
            start = System.nanoTime();   // start time
            binarySearch(arr, target);
            end = System.nanoTime();   // end time
            System.out.printf("Binary Search for N=%d: %.4f ms\n", n, (end - start) / 1e6);
        }
    }
}
