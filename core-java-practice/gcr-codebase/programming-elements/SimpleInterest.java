import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		
		int principal=sc.nextInt();
		int rate=sc.nextInt();;
		int time=sc.nextInt();;
		
		double si=(principal*rate*time)/100;
		
		System.out.println(si);

	}

}
