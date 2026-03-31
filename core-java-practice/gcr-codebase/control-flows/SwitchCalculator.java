import java.util.Scanner;
public class SwitchCalculator {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();

        // Perform calculation based on the operator using switch-case
        switch (op) {
            case "+": System.out.println(first + second); 
            break;

            case "-": System.out.println(first - second); 
            break;

            case "*": System.out.println(first * second); 
            break;

            case "/": System.out.println(second != 0 ? first / second : "Divide by zero"); 
            break;

            default: System.out.println("Invalid Operator");
        }
    }
}