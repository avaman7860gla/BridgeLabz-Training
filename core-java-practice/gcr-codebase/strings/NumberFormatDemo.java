import java.util.Scanner;

public class NumberFormatDemo {
    // Method to generate NumberFormatException
    public static void generateNumberFormat(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }

    // Method to handle NumberFormatException
    public static void handleNumberFormat(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } 
        
        catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } 
        
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        //taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to parse as integer: ");
        String input = sc.next();
        // generateNumberFormat(input);
        System.out.println("NumberFormatException handling:");
        handleNumberFormat(input);
    }
}
