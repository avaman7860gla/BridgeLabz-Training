import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {

        // paragraph
        String paragraph = "java streams make java code clean and java streams are powerful";

        // map of word count
        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                        .collect(Collectors.toMap(
                                word-> word,
                                word ->1,
                                Integer::sum   
                        ));

        wordCount.forEach((word, count)->System.out.println(word + " : " + count));
    }
}
