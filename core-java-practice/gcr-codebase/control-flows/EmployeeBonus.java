import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int year = sc.nextInt();
        // Check and print bonus based on years of service
        if (year > 5){
            double bonus = 0.05 * salary;
            System.out.println("Bonus: " + bonus);
        }
           
        else
            System.out.println("No bonus");
    }
}