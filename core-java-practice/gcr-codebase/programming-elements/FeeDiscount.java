
public class FeeDiscount {

	public static void main(String[] args) {
		double fee=125000.0;
		double discountPercentage=10.0;
		double discountedAmount=(fee*discountPercentage)/100;
		double discountedPrice=fee-discountedAmount;
		System.out.println("The discount amount is INR "+ discountedAmount +" and final discounted fee is INR "+discountedPrice);

	}

}
