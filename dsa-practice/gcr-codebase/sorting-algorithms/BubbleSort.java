import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;       
        boolean swapped;       

        for (int i = 0; i < n - 1; i++) {
            swapped = false;      // Reset swap flag for each pass

            // compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If current element is greater than next then swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];       
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;          // Mark swap flag true
                }
            }

            // If no swaps occurred then array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        // Call method to sort
        bubbleSort(marks);

        System.out.println("Sorted marks: " + Arrays.toString(marks));
    }
}
