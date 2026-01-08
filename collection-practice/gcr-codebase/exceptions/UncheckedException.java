import java.util.*;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // use try catch block for exception handling
        try {
            // user input
            System.out.print("Enter numerator = ");
            int a = scanner.nextInt();
            System.out.print("Enter denominator = ");
            int b = scanner.nextInt();

            System.out.println("Result: " + (a / b));
        } 
        // handling exception
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}