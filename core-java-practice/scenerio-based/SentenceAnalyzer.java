import java.util.*;

public class SentenceAnalyzer {

    // Count words in the paragraph
    public static int countWords(String para) {
        if (para == null || para.trim().isEmpty()) 
            return 0;
        int ans = para.trim().split("\\s+").length;
        return ans;
    }

    // Find the longest word
    public static String findLongestWord(String para) {
        if (para == null || para.trim().isEmpty()) 
            return "";
        String[] words = para.trim().split("\\s+");
        String ans = "";
        for (String word : words) {
            if (word.length() > ans.length()) {
                ans = word;
            }
        }
        return ans;
    }

    // Replace a word (case-insensitive)
    public static String replaceWord(String para, String oldWord, String newWord) {
        if (para == null || para.trim().isEmpty()) 
            return "";
        String ans = para.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
        return ans;
    }

    public static void main(String[] args) {
        String paragraph = "Java is powerful. java is versatile. I love JAVA!";
        
        System.out.println("Original Paragraph: " + paragraph);
        System.out.println("Word Count: " + countWords(paragraph));
        System.out.println("Longest Word: " + findLongestWord(paragraph));
        
        String replaced = replaceWord(paragraph, "java", "Python");
        System.out.println("After Replacement: " + replaced);
    }
}
