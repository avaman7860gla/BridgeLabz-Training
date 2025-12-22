import java.util.Scanner;

public class NumberCheckerDigits {
    // Count the number of digits in a number
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    // Get the digits of a number as an array
    public static int[] getDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Reverse the digits of a number
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Check if two arrays are equal
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // Check if a number is a palindrome
    public static boolean isPalindrome(int number) {
        int[] digits = getDigits(number);
        return areArraysEqual(digits, reverseDigits(digits));
    }

    // Check if a number is a duck number
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit != 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        // Taking input for a number
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Digits: " + java.util.Arrays.toString(getDigits(number)));
        System.out.println("Reversed digits: " + java.util.Arrays.toString(reverseDigits(getDigits(number))));
        System.out.println("Is palindrome: " + isPalindrome(number));
        System.out.println("Is duck number: " + isDuckNumber(number));

       
    }
}