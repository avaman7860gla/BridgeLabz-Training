import java.util.Scanner;

public class LargestSecondLargest {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int index = 0;

        // Extract digits and store in array

        while (number != 0 && index < 10) {
            digits[index++] = number % 10;
            number /= 10;
        }

        // Find largest and second largest digits

        int max = 0;
        int secondMax = 0;

        // Iterate through stored digits
        for (int i = 0; i < index; i++) {
            if (digits[i] > max) {
                secondMax = max;
                max = digits[i];
            } 
            else if (digits[i] > secondMax && digits[i] != max) {
                secondMax = digits[i];
            }
        }

        // Print results

        System.out.println("Largest digit: " + max);
        System.out.println("Second largest digit: " + secondMax);
    }
}