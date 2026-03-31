import java.util.Scanner;

public class BmiFitnessTracker {
    public static void main(String[] args){

        //take input from user
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your weight in kilograms:");
        double weight=sc.nextDouble();
        System.out.println("Enter your height in meters:");
        double height=sc.nextDouble();

        //calculate BMI
        double bmi=weight/(height*height);

        //determine BMI category
        if(bmi<18.5){
            System.out.println("Your BMI is "+bmi+" which is considered Underweight");
        } 
        else if(bmi>=18.5 && bmi<24.9){
            System.out.println("Your BMI is "+bmi+" which is considered Normal weight");
        } 
        else if(bmi>=25 && bmi<29.9){
            System.out.println("Your BMI is "+bmi+" which is considered Overweight");
        } 
        else {
            System.out.println("Your BMI is "+bmi+" which is considered Obesity");
        }

    }
}
