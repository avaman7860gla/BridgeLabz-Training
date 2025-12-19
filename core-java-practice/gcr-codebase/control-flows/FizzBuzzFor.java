import java.util.Scanner;
public class FizzBuzzFor {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //FizzBuzz logic using for loop
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (i % 3 == 0 && i % 5 == 0)
                    System.out.println("FizzBuzz");

                else if (i % 5 == 0)
                    System.out.println("Buzz");

                else if (i % 3 == 0)
                    System.out.println("Fizz");
                
                else
                    System.out.println(i);
            }
        } 
        else {
            System.out.println("Invalid input");
        }
    }
}