import java.util.Scanner;

public class NumberCheckerArmstrong {
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

    // Check if a number is a duck number
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit != 0) return true;
        }
        return false;
    }

    // Check if a number is an Armstrong number
    public static boolean isArmstrong(int number) {
        int[] digits = getDigits(number);
        int power = digits.length;
        long sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    // Find the largest and second largest digits
    public static int[] findLargestAndSecond(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } 
            else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // Find the smallest and second smallest digits
    public static int[] findSmallestAndSecond(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } 
            else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {

        // Taking input for a number
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();


        int[] digits = getDigits(number);

        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Is duck number: " + isDuckNumber(number));
        System.out.println("Is Armstrong: " + isArmstrong(number));


        int[] largest = findLargestAndSecond(digits);

        System.out.println("Largest digit: " + largest[0] + ", Second largest: " + largest[1]);
        
        int[] smallest = findSmallestAndSecond(digits);


        System.out.println("Smallest digit: " + smallest[0] + ", Second smallest: " + smallest[1]);
        
    }
}