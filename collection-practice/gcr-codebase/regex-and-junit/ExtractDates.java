import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    // method to extract dates in dd/mm/yyyy format
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();

        // regex to pattern match
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        
        // find matches
        while (matcher.find()){
            dates.add(matcher.group());
        }
        return dates;
    }

    public static void main(String[] args) {

        // input string
        String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020";

        // method call
        List<String> dates = extractDates(input);
        System.out.println(dates);
    }
}