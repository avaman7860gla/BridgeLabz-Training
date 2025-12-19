import java.util.Scanner;
public class GreatestFactorWhile {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        //Greatest factor logic using while loop
        int counter = number - 1;
        int greatestFactor = 1;
        while (counter >= 1) {

            //Check if counter is a factor of number
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest factor = " + greatestFactor);
    }
}