import java.util.Scanner;

public class StringCompression{

    public static String compress(String str){
        if (str.isEmpty()){
            return "";
        }
        StringBuilder ans=new StringBuilder();
        int c=1;
        for (int i=0;i<str.length();i++) {
            if (str.length()>i+1 && str.charAt(i)==str.charAt(i+1)){
                c++;
            } 
            else {
                ans.append(str.charAt(i)).append(c);
                c=1;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();

        System.out.println("compressed: " + compress(s));
        
    }
}
