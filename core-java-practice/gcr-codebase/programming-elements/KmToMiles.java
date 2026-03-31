import java.util.Scanner;

public class KmToMiles {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double km=input.nextDouble();
		double inMiles=1.6*km;
		System.out.println("The distance "+km+" km in miles is "+inMiles);

	}

}
