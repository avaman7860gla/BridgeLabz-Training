import java.util.Scanner;
public class MultiplesBelowHundredWhile {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        //Multiples below 100 logic using while loop
        int counter = 99;
        if (number > 0 && number < 100) {
            while (counter > 1) {   //Loop until counter is greater than 1
                //Check if counter is a multiple of number and print it(if true)
                if (counter % number == 0)
                    System.out.println(counter);
                counter--;
            }
        } 
        
        
        else {
            System.out.println("Invalid input");
        }
    }
}
