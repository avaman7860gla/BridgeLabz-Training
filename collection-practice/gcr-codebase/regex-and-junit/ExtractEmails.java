import java.util.regex.*;
import java.util.*;

public class ExtractEmails {
    // method to extract emails
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        // regex to match pattern
        Matcher matcher = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}").matcher(text);
        // find all matches
        while (matcher.find()){
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        // input string
        String input = "Contact us at support@example.com and info@company.org";

        // method call
        List<String> emails = extractEmails(input);
        System.out.println(emails);
    }
}