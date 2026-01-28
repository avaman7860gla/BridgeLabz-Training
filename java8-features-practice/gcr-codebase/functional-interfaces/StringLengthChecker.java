import java.util.Scanner;
import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {

        int maxLength = 20;

        // Function to calculate string length
        Function<String, Integer> getLength = message -> message.length();

        // Input string
        Scanner sc=new Scanner(System.in);
        String message = sc.next();

        int length = getLength.apply(message);

        if (length > maxLength) {
            System.out.println("Message exceeds limit " + length);
        } 
        else {
            System.out.println("Message is within limit " + length);
        }
    }
}
