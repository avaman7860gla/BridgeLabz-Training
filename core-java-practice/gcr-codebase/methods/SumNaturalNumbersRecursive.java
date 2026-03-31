import java.util.Scanner;

public class SumNaturalNumbersRecursive {

    // Calculate sum of first n natural numbers using recursion
    public static int sumRecursive(int n) {
        if (n <= 0) return 0;
        return n + sumRecursive(n - 1);
    }

    // Calculate sum of first n natural numbers using formula
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {

        // Taking input for n
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a natural number");
            return;
        }

        // Calculating sums using both methods
        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);

        System.out.println("Recursive sum: " + recursiveSum);
        System.out.println("Formula sum: " + formulaSum);
        System.out.println("Results match: " + (recursiveSum == formulaSum));
        
    }
}