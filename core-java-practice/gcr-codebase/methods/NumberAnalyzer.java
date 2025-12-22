import java.util.Scanner;

public class NumberAnalyzer {

    // Check if a number is positive
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Compare two numbers
    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 < num2) return -1;
        return 0;
    }

    public static void main(String[] args) {

        // Taking input for five numbers
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Analyzing each number
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
            if (isPositive(numbers[i])) {
                System.out.println(numbers[i] + " is " + (isEven(numbers[i]) ? "even" : "odd"));
            } 
            else {
                System.out.println(numbers[i] + " is negative");
            }
        }

        // Comparing first and last elements
        int comparison = compare(numbers[0], numbers[4]);
        
        System.out.println("First and last elements are " + 
            (comparison == 0 ? "equal" : comparison > 0 ? "first > last" : "first < last"));
        
    }
}