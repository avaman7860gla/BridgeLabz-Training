import java.util.*;

public class CensorBadWords {
    // method to censor words
    public static String censorBadWords(String text, List<String> badWords) {
        for (String word : badWords) {
            // regex that matches
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }
    public static void main(String[] args) {
        // add badwords in list
        List<String> badWords = Arrays.asList("badword1", "badword2", "badword3");

        // input sentence
        String text = "this is a badword1 and badword2";

        // method call
        String censored = censorBadWords(text, badWords);
        System.out.println(censored);
    }
}