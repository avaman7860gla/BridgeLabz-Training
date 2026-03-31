import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {

        // take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = scanner.nextInt();

        // generate Fibonacci sequence
        generateFibonacci(n);
    }


    // method to generate Fibonacci sequence
    public static void generateFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: ");

        // print Fibonacci numbers
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}
