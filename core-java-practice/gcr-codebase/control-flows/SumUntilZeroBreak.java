import java.util.Scanner;
public class SumUntilZeroBreak {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        // Sum numbers until a non-positive number is entered
        while (true) {
            double value = sc.nextDouble();
            if (value <= 0)
                break;
            total += value;
        }
        System.out.println("Total: " + total);
    }
}
