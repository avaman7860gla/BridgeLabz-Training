import java.util.Scanner;

public class NumberCheckerHarshad {
    // Get the digits of a number as an array
    public static int[] getDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Count the number of digits in a number
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    // Calculate the sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }


    // Calculate the sum of squares of digits
    public static long sumOfSquares(int[] digits) {
        long sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    // Check if a number is a Harshad number
    public static boolean isHarshad(int number) {
        return number % sumOfDigits(getDigits(number)) == 0;
    }

    // Get the frequency of each digit in the number
    public static int[][] getDigitFrequency(int number) {
        int[] digits = getDigits(number);
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }

        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }

    public static void main(String[] args) {

        // Taking input for a number
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Sum of digits: " + sumOfDigits(getDigits(number)));
        System.out.println("Sum of squares: " + sumOfSquares(getDigits(number)));
        System.out.println("Is Harshad: " + isHarshad(number));


        int[][] freq = getDigitFrequency(number);
        // Display digit frequencies
        for (int[] row : freq) {
            if (row[1] > 0) {
                System.out.println("Digit " + row[0] + ": " + row[1]);
            }
        }
     
    }
}