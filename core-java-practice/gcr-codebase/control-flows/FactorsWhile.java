import java.util.Scanner;
public class FactorsWhile {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //Factors logic using while loop
        
        
        int i = 1;
        if (number > 0) {
            while (i < number) {
                //Check if i is a factor of number
                if (number % i == 0)
                    System.out.println(i);
                i++;
            }
        } 
        else {
            System.out.println("Invalid input");
        }
    }
}