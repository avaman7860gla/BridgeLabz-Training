import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    // Recursive function to perform QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { 
            // Partition the array and get pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before pivot
            quickSort(arr, low, pi - 1);

            // Recursively sort elements after pivot
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;       // Index of smaller element

        
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++; // Increment index of smaller element

                // Swaping
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // return pivot index
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

    
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

    
        int[] prices = new int[n];

      
        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Call quickSort method
        quickSort(prices, 0, n - 1);

    
        System.out.println("Sorted product prices: " + Arrays.toString(prices));
    }
}
