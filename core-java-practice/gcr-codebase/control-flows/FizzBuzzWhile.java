import java.util.Scanner;
public class FizzBuzzWhile {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //FizzBuzz logic using while loop
        int i = 1;
        if (num > 0) {
            while (i <= num) {
                //Check divisibility and print appropriate output
                if (i % 3 == 0 && i % 5 == 0)
                    System.out.println("FizzBuzz");
                
                else if (i % 5 == 0)
                    System.out.println("Buzz");

                else if (i % 3 == 0)
                    System.out.println("Fizz");
                else

                    System.out.println(i);

                i++;
            }
        } 
        else {
            System.out.println("Invalid input");
        }
    }
}