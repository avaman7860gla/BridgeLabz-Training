import java.util.Scanner;

public class StudentScoresManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] scores = new double[n];
        double sum = 0;

        // input scores with validation
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + " = ");
            if (sc.hasNextDouble()) {
                double score = sc.nextDouble();
                if (score >= 0) {
                    scores[i] = score;
                    sum += score;
                } 
                else {
                    System.out.println("Invalid input");
                    scores[i] = 0;
                }
            } 
            else {
                System.out.println("Invalid input");
                sc.next(); // discard invalid input
                scores[i] = 0;
            }
        }

        // find average
        double avg = sum / n;
        System.out.println("\nAverage Score: " + avg);

        // find highest and lowest
        double highest = scores[0], lowest = scores[0];
        for (double score : scores) {
            if (score > highest) 
                highest = score;
            if (score < lowest) 
                lowest = score;
        }
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        // scores above average
        System.out.println("Students scoring above average:");
        for (int i = 0; i < n; i++) {
            if (scores[i] > avg) {
                System.out.println("Student " + (i + 1) + " = " + scores[i]);
            }
        }

    }
}
