import java.util.HashSet;
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>(); 
        for(char ch:jewels.toCharArray()){ 
            set.add(ch); 
        }
        int c=0; 
        for(char ch:stones.toCharArray()){ 
            if(set.contains(ch)){ 
                c++; 
            } 
        } 
        return c;
    }
}
