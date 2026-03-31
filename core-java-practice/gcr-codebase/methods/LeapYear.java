import java.util.Scanner;

public class LeapYear {

    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        // Taking input for a year
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        // Display if the year is a leap year or not
        System.out.println(isLeapYear(year) ? "Leap Year" : "Not a Leap Year");
        scanner.close();
    }
}