public class VowelConsonantCount {
    public static void main(String[] args) {
        String str = "Hello World";

        // Convert the string to lowercase
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } 
                else {
                    consonants++;
                }
            }
        }

        // Print the counts
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
