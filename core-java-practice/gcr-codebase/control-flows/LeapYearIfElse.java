import java.util.Scanner;
public class LeapYearIfElse {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        //Leap year logic using if-else statements
        if (year >= 1582) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0)
                        System.out.println("Leap Year");
                    
                    else
                        System.out.println("Not a Leap Year");
                } 
                
                else {
                    System.out.println("Leap Year");
                }
            } 
            
            else {
                System.out.println("Not a Leap Year");
            }
        } 
        
        else {
            System.out.println("Not a valid Gregorian year");
        }
    }
}