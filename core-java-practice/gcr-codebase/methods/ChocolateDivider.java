import java.util.Scanner;

public class ChocolateDivider {

    // Find the number of chocolates each child gets and the remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        result[0] = number / divisor;
        result[1] = number % divisor;
        return result;
    }

    public static void main(String[] args) {

        // Taking number of chocolates and number of children as input
        Scanner scanner = new Scanner(System.in);
        int numberOfChocolates = scanner.nextInt();
        int numberOfChildren = scanner.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Chocolates per child: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);
        
    }
}