import java.util.Scanner;
public class VotingEligibility {
    public static void main(String[] args) {
        //Take age as input
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        //Check voting eligibility by age criteria
        if (age >= 18)
            System.out.println("The person's age is " + age + " and can vote");
        else
            System.out.println("The person's age is " + age + " and cannot vote");
    }
}