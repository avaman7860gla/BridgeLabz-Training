import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        //Take month and day as input
        Scanner sc=new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        //Check for Spring season
        if ((month == 3 && day >= 20) || (month == 6 && day <= 20) || (month == 4 || month == 5))
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}