import java.util.Scanner;

// custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {
    // method to check age is valid or not
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        // exception handling
        try {
            validateAge(age);
            System.out.println("Access granted!");
        } 
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}