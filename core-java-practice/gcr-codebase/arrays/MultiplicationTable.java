import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //take input from user
        System.out.print("Enter a number = ");
        int number = sc.nextInt();

        int[] table = new int[10];

        //generate multiplication table
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        //print multiplication table
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
    }
}