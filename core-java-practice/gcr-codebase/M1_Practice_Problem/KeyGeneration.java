package M1_Practice_Problem;

import java.util.Scanner;

public class KeyGeneration {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        while(n-->0){
            String input=sc.nextLine();
            System.out.println(solve(input));
        }
    }

    public static String solve(String str){
        if(str.matches("^.{0,5}$")){
            return "Invalid Input (length < 6)";
        }

        if(str.matches(".*\\s.*")){
            return "Invalid Input (contains space)";
        }

        if(str.matches(".*\\d.*")){
            return "Invalid Input (contains digits)";
        }

        if(str.matches(".*[^a-zA-Z].*")){
            return "Invalid Input (contains special character)";
        }

        if(str.isEmpty()){
            return "Invalid Input (empty string)";
        }

        str=str.toLowerCase();

        StringBuilder sb=new StringBuilder(str);
        for(int i=0;i<sb.length();i++){
            int asci=sb.charAt(i);
            if(asci%2==0){
                sb.deleteCharAt(i);
                i--;
            }
        }

        sb=sb.reverse();

        StringBuilder res=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(i%2==0){
                res.append(Character.toUpperCase(ch));
            }
            else{
                res.append(ch);
            }
        }

        if(res.isEmpty()){
            return "Invalid Input (empty string)";
        }
        return "The generated key is - "+res;
    }
}
