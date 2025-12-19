import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        // Print multiplication table from 6 to 9 of entered number
        for (int i = 6; i <= 9; i++){
            
            System.out.println(number + " * " + i + " = " + (number * i));
        }
            
    }
}