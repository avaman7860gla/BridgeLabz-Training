import java.util.Scanner;

public class AreaOfTriangle {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		double baseInCm=sc.nextDouble();
		double heightInCm=sc.nextDouble();
		double baseInInches=baseInCm/2.54;
		double heightInInches=heightInCm/2.54;
		
		double areaInCm=0.5*baseInCm*heightInCm;
		double areaInInches=0.5*baseInInches*heightInInches;
		
		System.out.println("Area of triangle in cm is "+areaInCm+" and in inches is "+areaInInches);
		
		
		

	}

}
