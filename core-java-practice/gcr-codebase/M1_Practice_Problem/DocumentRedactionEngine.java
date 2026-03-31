package M1_Practice_Problem;

import java.util.Scanner;

public class DocumentRedactionEngine {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++) {
            String line=sc.nextLine();
            System.out.println(transformLine(line));
        }
    }

    public static String maskNationalID(String str){
        return str.replaceAll("ID:[A-Z]{3}\\d{6}", "ID:XXX******");
    }

    public static String maskBankAccountNumber(String str){
        return str.replaceAll("ACCT-\\d{4}-\\d{4}-(\\d{4})", "ACCT---$1");
    }

    public static String normalizeRepeatedWords(String str){
        return str.replaceAll("\\b(\\w+)\\s+\\1\\b", "$1");
    }

    public static String removeTrailingSpecialSymbols(String str){
        return str.replaceAll("([!?.])\\1{2,}", "$1");
    }

    public static String transformLine(String str) {
        str=maskNationalID(str);
        str=maskBankAccountNumber(str);
        str=normalizeRepeatedWords(str);
        str=removeTrailingSpecialSymbols(str);
        return str;
    }
}