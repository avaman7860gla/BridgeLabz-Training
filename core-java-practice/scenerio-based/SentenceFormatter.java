import java.util.*;
public class SentenceFormatter {
    // method for formating paragraph
    public static String formatParagraph(String para){

        // if input string is empty
        if(para == null && para.trim().isEmpty()){
            return "";
        }

        // this removes all extra spaces
        para = para.trim().replaceAll("\\s+", " ");

        // this ensures one space after punctuation
        para = para.replaceAll("([.!?])\\s*", "$1 ");

        // capatalise first letter of every sentence
        StringBuilder ans = new StringBuilder();
        boolean flag = true;   // flag to check capital next
        for (char c : para.toCharArray()) { 
            if (flag && Character.isLetter(c)) { 
                ans.append(Character.toUpperCase(c)); 
                flag = false; 
            } 
            else { 
                ans.append(c); 
            } 

            if (c == '.' || c == '?' || c == '!') { 
                flag = true; 
            } 
        } 
        return ans.toString().trim();

    }
    public static void main(String[] args){

        // input paragraph
        String paragraph = "hello world!this is java.    it is programming language?yes, it is.";
        System.out.println("Unformated string: "+paragraph);
        
        // after formated
        System.out.println("Formated String: "+formatParagraph(paragraph));
    }
}
