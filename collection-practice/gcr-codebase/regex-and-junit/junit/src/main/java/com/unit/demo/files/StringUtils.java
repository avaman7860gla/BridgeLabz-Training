package com.unit.demo.files;

public class StringUtils {

    // method to reverse string
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // method to check palindrome string
    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    // method to string uppercase
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        StringUtils utils = new StringUtils();

        String input = "Madam";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + utils.reverse(input));
        System.out.println("Is Palindrome: " + utils.isPalindrome(input));
        System.out.println("Uppercase: " + utils.toUpperCase(input));
    }
}
