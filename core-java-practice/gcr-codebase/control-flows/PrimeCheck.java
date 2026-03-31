import java.util.Scanner;
public class PrimeCheck {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //Prime number check logic
        boolean isPrime = true;
        if (num <= 1) isPrime = false;

        //Check for factors from 2 to num/2
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        //Output result
        if(isPrime){
            System.out.println("Prime Number");
            
        }
        else{
            System.out.println("Not a Prime Number");
        }
    }
}