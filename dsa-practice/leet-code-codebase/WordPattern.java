import java.util.HashMap;
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToWord=new HashMap<>();
        HashMap<String, Character> wordToChar=new HashMap<>();

        String[] words=s.split(" ");

        if(words.length!=pattern.length()) return false;

        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=words[i];

            if (charToWord.containsKey(ch)) { 
                if (!charToWord.get(ch).equals(word)) return false; 
            } 
            else { 
                if (wordToChar.containsKey(word)) return false;
                charToWord.put(ch, word); 
                wordToChar.put(word, ch); 
            }
        }
        return true;
    }
}