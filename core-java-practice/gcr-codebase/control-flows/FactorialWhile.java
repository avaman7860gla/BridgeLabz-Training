import java.util.Scanner;
public class FactorialWhile {
    public static void main(String[] args) {
        //Take a input from user
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //Find factorial using while loop and check input is valid or not
        if (num >= 0) {
            int factorial = 1;
            int i = 1;
            while (i <= num) {
                factorial *= i;
                i++;
            }
            System.out.println("Factorial = " + factorial);
        } 
        else {
            System.out.println("Invalid input");
        }
    }
}