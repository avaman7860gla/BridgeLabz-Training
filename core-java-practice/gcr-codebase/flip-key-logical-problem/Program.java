import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the word ");
        String input=sc.next();

        System.out.println("The generated key is - "+cleanseAndInvert(input));
    }

    public static String cleanseAndInvert(String input){
        if(input.isEmpty() || input.length()<6){
            return "";
        }
        if(!input.matches("^[A-Za-z]+$")){
            return "";
        }

        String str=input.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            int val=str.charAt(i);
            if(val%2!=0){
                sb.append((char)val);
            }
        }
        sb=sb.reverse();
        for(int i=0;i<sb.length();i++){
            if(i%2==0){
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
        }
        return sb.toString();
        
    } 
}
