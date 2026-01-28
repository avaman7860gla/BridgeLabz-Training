import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // input first word
        System.out.println("Enter First Word: ");
        String first=sc.nextLine();

        // check first word is valid or not 
        if(first.trim().contains(" ")){
            System.out.println(first+" is an invalid word");
            return;
        }
        // input second word
        System.out.println("Enter Second Word: ");
        String second=sc.nextLine();

        // check second word is valid or not
        if(second.trim().contains(" ")){
            System.out.println(second+" is an invalid word");
            return;
        }

        // if second word is reversed of first
        if(ifReversed(first, second)){
            String word=second.toLowerCase();
            System.out.println(replaceVowels(word));
        }
        // if second word is not reversed of first
        else{
            String combine=(first+second).toUpperCase();

            // count number of vowels and consonants
            int vowels=countVowels(combine);
            int consonants=countConsonants(combine);

            // if vowel is greater than consonants
            if(vowels>consonants){

                // use linked hashset to keep sequence order
                Set<Character> set=new LinkedHashSet<>();
                for(char ch:combine.toCharArray()){
                    if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                        set.add(ch);
                    }
                }
                // display first 2 unique vowels
                int v=0;
                for(char ch:set){
                    System.out.print(ch);
                    v++;
                    if(v>=2) break;
                }
            }
            // if vowel is lesser than consonants
            else if(consonants>vowels){

                // use linked hashset to keep sequence order
                Set<Character> set=new LinkedHashSet<>();
                for(char ch:combine.toCharArray()){
                    if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                        continue;
                    }
                    else{
                        set.add(ch);
                    }
                }
                // display first 2 unique consonants
                int c=0;
                for(char ch:set){
                    System.out.print(ch);
                    c++;
                    if(c>=2) break;
                }
            }
            // if vowel is equal to consonants
            else{
                System.out.println("Vowels and Consonants are Equal");
            }
        }

    }

    // method to check second word is reverse of first or not
    public static boolean ifReversed(String first, String second){
        String s1=first.toLowerCase();
        String s2=second.toLowerCase();
        StringBuilder sb=new StringBuilder(s2);
        String rev=sb.reverse().toString();
        if(s1.equals(rev)) return true;
        return false;
    }

    // method to replace vowels with @
    public static String replaceVowels(String word){
        String replaced=word.replaceAll("[aeiouAEIOU]", "@");
        return replaced;
    }

    // method to count number of vowels
    public static int countVowels(String word){
        int count=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                count++;
            }
        }
        return count;
    }
    // method to count number of consonants
    public static int countConsonants(String word){
        return word.length()-countVowels(word);
    }
}
