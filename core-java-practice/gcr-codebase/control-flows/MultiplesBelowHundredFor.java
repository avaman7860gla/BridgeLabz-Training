import java.util.Scanner;
public class MultiplesBelowHundredFor {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        //Multiples below 100 logic using for loop
        if (number > 0 && number < 100) {
            for (int i = 100; i >= 1; i--) {
                //Check if i is a multiple of number and print it(if true)
                if (i % number == 0)
                    System.out.println(i);
            }
        } 
        
    
        else {
            System.out.println("Invalid input");
        }
    }
}