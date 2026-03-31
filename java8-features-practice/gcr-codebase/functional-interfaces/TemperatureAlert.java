import java.util.Scanner;
import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        double threshold = 37.5;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter current temperature: ");
        double currentTemp = sc.nextDouble();
        
        // Predicate to check high temperature
        Predicate<Double> isHighTemp = temp -> temp > threshold;
        if(isHighTemp.test(currentTemp)){
            System.out.println("Temperature is high: " + currentTemp);
        } 
        else{
            System.out.println("Temperature is normal: " + currentTemp);
        }
    }
}
