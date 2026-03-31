import java.util.regex.*;
import java.util.*;

public class ExtractLinks {
    // method to extract links
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();

        // regext that matches url patterns
        Matcher matcher = Pattern.compile("https?://\\S+").matcher(text);
        // find all matches
        while (matcher.find()){
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {

        // string input
        String input = "Visit https://www.google.com and http://example.org";

        // method call
        List<String> links = extractLinks(input);
        System.out.println(links);
    }
}