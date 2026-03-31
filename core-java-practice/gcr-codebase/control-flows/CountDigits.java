import java.util.Scanner;
public class CountDigits {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        // Count digits logic
        int count = 0;
        
        // Calculate the number of digits
        while (number != 0) {
            number /= 10;
            count++;
        }
        System.out.println("Digits = " + count);
    }
}