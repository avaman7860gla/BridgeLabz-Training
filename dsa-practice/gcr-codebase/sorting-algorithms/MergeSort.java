import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    // Recursive function to divide the array into halves and sort them
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { 
            int mid = (left + right) / 2; 

            // Recursively sort the left half
            mergeSort(arr, left, mid);

            // Recursively sort the right half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // merge two sorted halves into a single sorted array
    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // arrays to hold left and right halves
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into these arrays
        for (int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }
            
        for (int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }
            

        // Merge the temporary arrays
        int i = 0;
        int j = 0;
        int k = left;

        // Compare elements from both halves and insert the smaller one
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } 
            else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of left array
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy remaining elements of right array
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

      
        int[] prices = new int[n];

       
        System.out.println("Enter book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Call mergeSort method
        mergeSort(prices, 0, n - 1);

      
        System.out.println("Sorted book prices: " + Arrays.toString(prices));
    }
}
