import java.util.Scanner;

public class CompareStringsCharAt {
    // Method to compare two strings using charAt
    public static boolean compareByCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) 
            return false;
        // Comparing character by character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) 
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Comparing using charAt method

        boolean userResult = compareByCharAt(str1, str2);
        boolean builtInResult = str1.equals(str2);


        // Displaying results

        System.out.println("User-defined comparison: " + userResult);
        System.out.println("Built-in equals() comparison: " + builtInResult);
        System.out.println("Are both results same? " + (userResult == builtInResult));
    }
}
