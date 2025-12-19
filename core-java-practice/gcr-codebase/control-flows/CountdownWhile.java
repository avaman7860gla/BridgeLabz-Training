import java.util.Scanner;
public class CountdownWhile {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int decCounter = sc.nextInt();
        // Countdown from number to 1
        while (decCounter >= 1) {
            System.out.println(decCounter);
            decCounter--;
        }
    }
}