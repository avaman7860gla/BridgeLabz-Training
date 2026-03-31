public class RemoveDuplicates {
    public static void main(String[] args) {

    
        String str = "programming";
        String result = "";
        // Remove duplicate characters

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Check if character is already in result
            if (result.indexOf(ch) == -1) { 
                result += ch;
            }
        }

        System.out.println("Without duplicates = " + result);
    }
}
