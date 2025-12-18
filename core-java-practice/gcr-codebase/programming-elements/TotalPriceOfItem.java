import java.util.Scanner;

public class TotalPriceOfItem {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		double unitPrice=sc.nextDouble();
		
		int qty=sc.nextInt();
		
		double totalPrice=unitPrice*qty;
		
		System.out.println("The total purchase price is INR "+ totalPrice +" if the quantity "+ qty +" and unit price is INR "+unitPrice);

	}

}
