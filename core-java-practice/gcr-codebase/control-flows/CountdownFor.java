import java.util.Scanner;
public class CountdownFor {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        int counter = sc.nextInt();
        
        // Countdown from number to 1 using for
        for (int i = counter; i >= 1; i--){
            System.out.println(i);
        }  
    }
}