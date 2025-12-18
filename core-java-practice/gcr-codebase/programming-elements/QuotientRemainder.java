import java.util.Scanner;

public class QuotientRemainder {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		
		int remainder=num1%num2;
		int quotient=num1/num2;
		
		System.out.println("The Quotient is "+quotient+" and Reminder is "+remainder +" of two number "+num1+" and "+num2);

	}

}
