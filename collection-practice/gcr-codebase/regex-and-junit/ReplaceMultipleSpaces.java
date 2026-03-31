public class ReplaceMultipleSpaces {

    // method to replace multiple spaces
    public static String replaceMultipleSpaces(String text) {

        // regex pattern 
        return text.replaceAll("\\s{2,}", " ");
    }

    public static void main(String[] args) {
        // string input 
        String input = "This is an example with    multiple spaces";
        // method call
        String ans = replaceMultipleSpaces(input);
        System.out.println(ans);

    }
}