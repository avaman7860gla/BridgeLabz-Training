import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        // Armstrong number check logic
        int original = number;
        int sum = 0;

        // Calculate the sum of cubes of each digit
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }

        // Output result
        if (sum == original)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not an Armstrong Number");
    }
}