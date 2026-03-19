package M1_Practice_Problem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTagScoringEngine {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        while(n-->0){
            String input=sc.nextLine();
            System.out.println(evaluate(input));
        }
    }

    public static String evaluate(String input) {
        String regex = "\\[(SUM|MUL|MAX|MIN):(-?(?:0|[1-9]\\d*)(?:,-?(?:0|[1-9]\\d*))+)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String type = matcher.group(1);
            String value = matcher.group(2);

            String[] nums = value.split(",");
            int ans = 0;

            switch (type) {
                case "SUM":
                    ans = 0;
                    for (String n : nums)
                        ans += Integer.parseInt(n);
                    break;

                case "MUL":
                    ans = 1;
                    for (String n : nums)
                        ans *= Integer.parseInt(n);
                    break;

                case "MAX":
                    ans = Integer.MIN_VALUE;
                    for (String n : nums)
                        ans = Math.max(ans, Integer.parseInt(n));
                    break;

                case "MIN":
                    ans = Integer.MAX_VALUE;
                    for (String n : nums)
                        ans = Math.min(ans, Integer.parseInt(n));
                    break;
            }
            matcher.appendReplacement(result, String.valueOf(ans));
        }
        matcher.appendTail(result);
        return result.toString().replaceAll("\\[[^\\]]*\\]", "ERROR")
                .replaceAll("\\[[^\\]]*", "ERROR");
    }
}
