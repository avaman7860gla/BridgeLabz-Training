import java.util.Scanner;

public class GCDLCMCalculator {
    public static void main(String[] args) {
        // take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        // calculate and display GCD and LCM
        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));
    }

    // method to calculate GCD
    public static int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a % b);
    }

    // method to calculate LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
