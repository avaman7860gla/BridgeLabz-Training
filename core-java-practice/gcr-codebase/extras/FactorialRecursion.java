import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        // take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }

    // recursive method to calculate factorial
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
