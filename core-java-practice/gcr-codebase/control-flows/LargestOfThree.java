import java.util.Scanner;
public class LargestOfThree {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt(), number2 = sc.nextInt(), number3 = sc.nextInt();
        // Check which number is the largest
        if(number1 > number2 && number1 > number3)
            System.out.println("Is the first number the largest? Yes");
        else if(number2 > number1 && number2 > number3)
            System.out.println("Is the second number the largest? Yes");
        else if(number3 > number1 && number3 > number2)
            System.out.println("Is the third number the largest? Yes");
    }
}