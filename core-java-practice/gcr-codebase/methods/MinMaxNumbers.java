import java.util.Scanner;

public class MinMaxNumbers {
    // Find the smallest and largest among three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int[] result = new int[2];
        result[0] = Math.min(Math.min(number1, number2), number3);
        result[1] = Math.max(Math.max(number1, number2), number3);
        return result;
    }

    public static void main(String[] args) {

        // Taking input for three numbers
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        // Finding and displaying the smallest and largest numbers
        int[] result = findSmallestAndLargest(num1, num2, num3);
        
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
        
    }
}