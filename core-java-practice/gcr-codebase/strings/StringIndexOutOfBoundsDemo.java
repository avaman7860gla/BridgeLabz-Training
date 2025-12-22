import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        // Accessing index out of bounds
        System.out.println(text.charAt(text.length()));
    }

    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } 
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } 
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        // generateException(input);
        System.out.println("StringIndexOutOfBoundsException handling:");
        handleException(input);
    }
}
