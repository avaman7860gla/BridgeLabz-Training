import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        double totalBonus = 0;
        int totalOldSalary = 0;
        int totalNewSalary = 0;

        // Read salaries and years of service for 10 employees
        for (int i = 0; i < 10; ) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double salary = sc.nextDouble();
            System.out.print("Enter years of service: ");
            double year = sc.nextDouble();

            // Validate input
            if (salary <= 0 || year < 0) {
                System.out.println("Invalid input, try again.");
                continue;
            }

            // Store data and calculate bonus
            salaries[i] = salary;
            years[i] = year;

            double bonus = (year > 5) ? salary * 0.05 : salary * 0.02;
            bonuses[i] = bonus;
            newSalaries[i] = salary + bonus;

            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += newSalaries[i];
            i++;
        }

        // Print summary
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}