import java.util.Scanner;

public class StoreUntilZero {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        // Read numbers until zero or array is full
        while (true) {
            System.out.print("Enter a number: ");
            double input = sc.nextDouble();

            // Break if input is zero or array is full
            if (input <= 0 || index == 10)
                break;

            // Store the input in the array
            values[index++] = input;
        }

        // Print stored numbers and calculate total
        System.out.println("Stored numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(values[i] + " ");
            total += values[i];
        }

        // Print the total
        System.out.println("\nTotal= " + total);
    }
}