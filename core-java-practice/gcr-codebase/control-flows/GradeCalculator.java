import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        //Take input from the user
        Scanner sc = new Scanner(System.in);
        int phy = sc.nextInt();
        int chem = sc.nextInt();
        int math = sc.nextInt();

        //Calculate total and average
        int total = phy + chem + math;

        //Determine grade based on average
        double percentage = total / 3.0;


        System.out.println("Average: " + percentage);

        //Grade calculation using if-else statements
        if (percentage >= 80)
            System.out.println("Grade: A");

        else if (percentage >= 70)
            System.out.println("Grade: B");

        else if (percentage >= 60)
            System.out.println("Grade: C");

        else if (percentage >= 50)
            System.out.println("Grade: D");

        else if (percentage >= 40)
            System.out.println("Grade: E");

        else
            System.out.println("Grade: R");

    }
}