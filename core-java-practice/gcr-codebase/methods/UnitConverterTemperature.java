import java.util.Scanner;

public class UnitConverterTemperature {

    // Convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {

        // Taking input for Fahrenheit
        Scanner scanner = new Scanner(System.in);
        double fahrenheit = scanner.nextDouble();
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + convertCelsiusToFahrenheit(celsius));
        
    }
}