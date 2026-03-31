import java.util.Scanner;

public class CmToFeetInches {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		double heightInCm=sc.nextDouble();
		double inInches=heightInCm/2.54;
		double inFoot=inInches/12;
		
		System.out.println("Your Height in cm is " + heightInCm + " while in feet is "+ inFoot +" and inches is "+inInches);

	}

}
