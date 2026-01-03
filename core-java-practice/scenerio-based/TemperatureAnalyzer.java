import java.util.Random;

public class TemperatureAnalyzer {

    // analyze weekly temperature data
    public static void analyzeTemperatures(float[][] temp) {
        int hottestDay = 0;
        int coldestDay = 0;
        float maxAvg = Float.MIN_VALUE;
        float minAvg = Float.MAX_VALUE;

        // iterate each day
        for (int day = 0; day < temp.length; day++) {
            float sum = 0;
            for (int hour = 0; hour < temp[day].length; hour++) {
                sum += temp[day][hour];
            }
            float avg = sum / temp[day].length;
            System.out.println("Day " + (day + 1) + " average temperature: " + avg);

            // find hottest and coldest day by average
            if (avg > maxAvg) {
                maxAvg = avg;
                hottestDay = day;
            }
            if (avg < minAvg) {
                minAvg = avg;
                coldestDay = day;
            }
        }

        System.out.println("Hottest Day: " + (hottestDay + 1) + " with avg " + maxAvg);
        System.out.println("Coldest Day: " + (coldestDay + 1) + " with avg " + minAvg);
    }

    public static void main(String[] args) {
        // generate random temperatures
        float[][] temperatures = new float[7][24];
        Random rand = new Random();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temperatures[i][j] = 15 + rand.nextFloat() * 20; // temperature between 15°C to 35°C
            }
        }

        analyzeTemperatures(temperatures);
    }
}
