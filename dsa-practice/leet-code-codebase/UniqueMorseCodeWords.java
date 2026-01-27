public class UniqueMorseCodeWords {
    static final String[] letter = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                                    ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
                                    ".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set=new HashSet<>(); 
        for (String str:words) { 
            StringBuilder sb=new StringBuilder(); 
            for (char c:str.toCharArray()) { 
                sb.append(letter[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}