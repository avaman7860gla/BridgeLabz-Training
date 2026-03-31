import java.util.Scanner;
public class PowerCalculatorWhile {
    public static void main(String[] args) {

        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        
        //Power calculation logic using while loop
        int result = 1;
        int counter = 0;

        
        //Loop until counter is less than power
        while (counter < power) {
            result *= number;
            counter++;
        }
        System.out.println("Result =  " + result);
    }
}