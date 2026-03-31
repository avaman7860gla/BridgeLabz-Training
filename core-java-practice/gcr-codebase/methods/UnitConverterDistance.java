import java.util.Scanner;

public class UnitConverterDistance {
    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    // Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    // Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {

        // Taking input for kilometers and meters
        Scanner scanner = new Scanner(System.in);
        double km = scanner.nextDouble();

        System.out.println("Miles: " + convertKmToMiles(km));
        System.out.println("Kilometers: " + convertMilesToKm(convertKmToMiles(km)));
        double meters = scanner.nextDouble();
        System.out.println("Feet: " + convertMetersToFeet(meters));
        System.out.println("Meters: " + convertFeetToMeters(convertMetersToFeet(meters)));
        
    }
}