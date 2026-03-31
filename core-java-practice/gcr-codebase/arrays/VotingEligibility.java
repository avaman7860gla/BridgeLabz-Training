import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Declare an array to hold the ages of 10 students and read the ages from user input
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + " = ");
            ages[i] = sc.nextInt();
        }

        // Check voting eligibility for each age and print the result
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } 
            else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote");
            } 
            else {
                System.out.println("The student with the age " + age + " cannot vote");
            }
        }
    }
}