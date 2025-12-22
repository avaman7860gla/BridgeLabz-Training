public class LongestWord {
    public static void main(String[] args) {

        // Find the longest word in a sentence
        String sentence = "Java programming is powerful";
        String[] words = sentence.split(" ");
        String longest = "";
        // Loop through words to find the longest

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("Longest word = " + longest);
    }
}
