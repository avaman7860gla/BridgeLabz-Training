public class SubstringOccurrences {
    public static void main(String[] args) {

        // Count occurrences of a substring in a string
        String str = "abababab";
        String sub = "ab";
        int count = 0;
        
        // Loop through the string
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            // Check if substring matches
            if (str.substring(i, i + sub.length()).equals(sub)) {
                count++;
            }
        }
        System.out.println("Occurrences of '" + sub + "'= " + count);
    }
}
