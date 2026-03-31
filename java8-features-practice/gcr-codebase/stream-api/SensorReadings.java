import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {

        // list of readings
        List<Double> readings = List.of(28.5, 35.2, 31.8, 40.0, 26.9);
        double threshold = 30.0;
        readings.stream().filter(value -> value > threshold)
                .forEach(value ->
                System.out.println("High reading: " + value));
    }
}
