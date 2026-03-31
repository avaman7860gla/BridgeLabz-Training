import java.util.Scanner;
public class PowerCalculatorFor {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        
        //Power calculation logic using for loop
        int result = 1;
        for (int i = 1; i <= power; i++){
            result *= number;
        }
            
        System.out.println("Result: " + result);
    }
}