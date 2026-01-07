import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        // hashmap for word and its count
        Map<String, Integer> wordCount = new HashMap<>();

        // read words.txt file
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            // count
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // compare and get values with respectives keys
            wordCount.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}