import java.util.Scanner;
public class LeapYearUsingLogicalOperators {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        //Leap year logic using logical operators
        if (year >= 1582 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0))
            System.out.println("Leap Year");
        else
            System.out.println("Not a Leap Year");
    }
}