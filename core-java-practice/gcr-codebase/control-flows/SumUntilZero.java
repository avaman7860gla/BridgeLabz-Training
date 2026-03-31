import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        double num;

        // Sum numbers until zero is entered
        while (true) {
            num = sc.nextDouble();
            if (num == 0)
                break;
            total += num;
        }
        System.out.println(total);
    }
}