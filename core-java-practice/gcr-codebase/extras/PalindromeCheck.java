public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "nitin";

        // Initialize a flag to true
        boolean isPalindrome = true;

        // Check for palindrome
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        // Print the result
        System.out.println(str + " is palindrome? " + isPalindrome);
    }
}
