import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {

        // take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        System.out.print("Choose operation (+, -, *, /) =  ");
        char op = scanner.next().charAt(0);

        // perform operation based on user choice using switch-case
        switch (op) {
            case '+': 
                System.out.println("Result: " + add(a, b)); 
                break;
            case '-': 
                System.out.println("Result: " + subtract(a, b)); 
                break;
            case '*': 
                System.out.println("Result: " + multiply(a, b)); 
                break;
            case '/': 
                System.out.println("Result: " + divide(a, b)); 
                break;
            default: 
                System.out.println("Invalid operation.");
        }
    }

    // methods for basic operations
    static double add(double a, double b) { 
        return a + b; 
    }
    static double subtract(double a, double b) {
        return a - b; 
    }
    static double multiply(double a, double b) { 
        return a * b; 
    }
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }
}
