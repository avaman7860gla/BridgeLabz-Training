import java.util.Scanner;

public class YardsMilesFeet {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		double distanceInFeet=sc.nextDouble();
		
		double distanceInYards=distanceInFeet/3;
		double distanceInMiles=distanceInYards/1760;
		
		System.out.println("Your distance in feet is "+distanceInFeet+" while in Yards is "+distanceInYards+" and in Miles is "+distanceInMiles);
		
		
		
		

	}

}
