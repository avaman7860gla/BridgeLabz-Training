import java.util.Scanner;

public class FactorsCalculator {

    // Find all factors of a number
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        // Create an array to hold the factors
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    // Get the greatest factor from the factors array
    public static int greatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    // Calculate the sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Calculate the product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Calculate the product of cubes of factors
    public static long productOfCubes(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static void main(String[] args) {

        // Taking input for a number
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int[] factors = findFactors(number);
        
        System.out.println("Factors: " + java.util.Arrays.toString(factors));
        System.out.println("Greatest factor: " + greatestFactor(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Product of cubes: " + productOfCubes(factors));
        
    }
}