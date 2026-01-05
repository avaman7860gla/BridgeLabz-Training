import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {

        // string input
        String text = "Hello world, hello Java!";
        
        // for lower case and replace things except character
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase(); 

        // string to array of string
        String[] words = text.split("\s+");

        // map
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // display
        System.out.println(wordCount);
    }
}