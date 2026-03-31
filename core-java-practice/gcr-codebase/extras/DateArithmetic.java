import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {

        // take input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = scanner.nextLine();

        // parse the input date
        LocalDate date = LocalDate.parse(input);

        // perform date arithmetic
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);


        // display the result
        System.out.println("Final date after operations = " + result);
    }
}
