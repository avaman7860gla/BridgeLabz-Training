import java.util.Scanner;
public class NumberSignCheck {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        // Check if the number is positive, negative, or zero
        if (number > 0)
            System.out.println("Positive");
        else if (number < 0)
            System.out.println("Negative");
        else
            System.out.println("Zero");
    }
}