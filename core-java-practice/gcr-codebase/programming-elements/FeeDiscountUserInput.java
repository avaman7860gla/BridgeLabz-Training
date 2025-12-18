import java.util.Scanner;

public class FeeDiscountUserInput {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double fee=sc.nextDouble();
		double discountPercentage=sc.nextDouble();
		double discountedAmount=(fee*discountPercentage)/100;
		double discountedPrice=fee-discountedAmount;
		System.out.println("The discount amount is INR "+ discountedAmount +" and final discounted fee is INR "+discountedPrice);


	}
}
