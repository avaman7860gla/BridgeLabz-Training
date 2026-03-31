package M1_Practice_Problem;
import java.util.Scanner;

public class CorporateEmailAccessControl {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0){
            String email=sc.next();
            System.out.println(process(email));
        }
    }

    public static String process(String email) {
        if(email.matches("^[a-z]{3,}\\.[a-z]{3,}\\d{4,}@(sales|marketing|IT|product)\\.company\\.com")){
            return "Access Granted";
        }
        return "Access Denied";
    }
}
