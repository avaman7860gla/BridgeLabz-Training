import java.util.Scanner;

public class UnitConverterLength {

    // Convert yards to feet
    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    // Convert feet to yards
    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    // Convert meters to inches
    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }
    // Convert inches to meters
    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }
    // Convert inches to centimeters
    public static double convertInchesToCm(double inches) {
        return inches * 2.54;
    }

    public static void main(String[] args) {

        // Taking input for yards, meters, and inches
        Scanner scanner = new Scanner(System.in);
        double yards = scanner.nextDouble();

        System.out.println("Feet: " + convertYardsToFeet(yards));
        double meters = scanner.nextDouble();

        System.out.println("Inches: " + convertMetersToInches(meters));
        double inches = scanner.nextDouble();

        System.out.println("Centimeters: " + convertInchesToCm(inches));
       
    }
}