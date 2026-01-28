import java.util.Scanner;

interface UnitConverter {

    // method to convert km to miles
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // method to convert kg to pounds
    public static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}

public class UnitConversionDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter distance in Km: ");
        double distanceKm = sc.nextDouble();
        System.out.println("Enter weight in Kg: ");
        double weightKg = sc.nextDouble();

        System.out.println(distanceKm + " km = " +UnitConverter.kmToMiles(distanceKm) + " miles");

        System.out.println(weightKg + " kg = " +UnitConverter.kgToPounds(weightKg) + " pounds");
    }
}
