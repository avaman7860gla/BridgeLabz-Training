import java.util.Scanner;
public class SumNaturalNumbers {
    public static void main(String[] args) {
        //Take a input from user
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Find sum and check n is natural number or not
        if (n > 0) {
            int sum = 0;
            int i = 1;
            while (i <= n) {
                sum = sum + i;
                i++;
            }
            int sumFormula =(n * (n + 1)) / 2;
            System.out.println("using loop: " + sum);
            System.out.println("using formula: " + sumFormula);
        } 
        else {
            System.out.println("Not a natural number");
        }
    }
}