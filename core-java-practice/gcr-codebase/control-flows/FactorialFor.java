import java.util.Scanner;
public class FactorialFor {
    public static void main(String[] args) {
        //Take input from user
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int factorial = 1;
        //Find factorial using for loop and check input is valid or not
        if (num >= 0) {
            for (int i = 1; i <= num; i++)
                factorial *= i;
            System.out.println("Factorial = " + factorial);
        } 
        else {
            System.out.println("Invalid input");
        }
    }
}