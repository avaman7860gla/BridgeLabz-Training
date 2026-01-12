import java.util.regex.*;
import java.util.*;

public class ExtractCapitalizedWords {
    // method to extract capitalized words
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        // regex pattern
        Matcher matcher = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b").matcher(text);

        // find all matches
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {

        // input string
        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York";
        List<String> captalisedWord = extractCapitalizedWords(input);

        // display output
        System.out.println(captalisedWord);

    }
}