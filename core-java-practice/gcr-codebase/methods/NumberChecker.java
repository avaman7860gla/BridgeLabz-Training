import java.util.Scanner;

public class NumberChecker {
    // Check if a number is positive, negative, or zero
    public static int checkNumber(int number) {
        if (number > 0) return 1;
        else if (number < 0) return -1;
        else return 0;
    }

    public static void main(String[] args) {

        // Taking input for a number
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        // Checking the number and displaying the result
        int result = checkNumber(number);
        System.out.println(result == 1 ? "Positive" : result == -1 ? "Negative" : "Zero");
       
    }
}