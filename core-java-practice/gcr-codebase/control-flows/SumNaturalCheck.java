import java.util.Scanner;
public class SumNaturalCheck {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Check if the number is a natural number and calculate the sum
        if (n > 0){
            int sum=(n * (n + 1) / 2);
             System.out.println("The sum of " + n + " natural numbers is "+sum);
        }
        else
            System.out.println("The number " + n + " is not a natural number");
    }
}