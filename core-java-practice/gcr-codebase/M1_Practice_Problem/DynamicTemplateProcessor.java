package M1_Practice_Problem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicTemplateProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();

        while(num-- > 0){
            String input = sc.nextLine();
            process(input);
        }
    }

    public static void process(String input){
        String regex="\\$\\{(\\w+):(.*?)\\}";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        String ans=new String(input);

        while (matcher.find()){
            String type= matcher.group(1);
            String value= matcher.group(2);
            String replacement="";

            try{
                switch(type){
                    case "DATE":{
                        DateTimeFormatter in=DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        DateTimeFormatter out=DateTimeFormatter.ofPattern("yyyy/MM/dd");

                        LocalDate date=LocalDate.parse(value, in);
                        replacement= date.format(out);
                        break;
                    }

                    case "UPPER":{
                        replacement=value.toUpperCase();
                        break;
                    }

                    case "LOWER":{
                        replacement=value.toLowerCase();
                        break;
                    }

                    case "REPEAT":{
                        String[] parts=value.split(",");
                        String word=parts[0];
                        int count=Integer.parseInt(parts[1]);

                        StringBuilder sb=new StringBuilder();
                        for(int i=0;i<count;i++){
                            sb.append(word);
                        }

                        replacement=sb.toString();
                        break;
                    }

                    default:
                        replacement="INVALID";
                }
            }
            catch (Exception e) {
                replacement="INVALID";
            }
            ans=ans.replace(matcher.group(0), replacement);
        }
        System.out.println(ans);
    }
}
