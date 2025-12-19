import java.util.Scanner;
public class FactorsFor {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //Factors logic using for loop
        if (number > 0) {
            for (int i = 1; i < number; i++) {
                if (number % i == 0){
                    System.out.println(i);
                }
                    
            }
        } 
        
        else {
            System.out.println("Invalid input");
        }

    }
}