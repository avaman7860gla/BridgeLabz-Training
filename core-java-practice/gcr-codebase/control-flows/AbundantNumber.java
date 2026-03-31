import java.util.Scanner;
public class AbundantNumber {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        
        // Abundant number check logic
        int sum = 0;

        // Calculate the sum of proper divisors
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        // Output result
        if (sum > num)
            System.out.println("Abundant Number");
        else
            System.out.println("Not an Abundant Number");
    }
}