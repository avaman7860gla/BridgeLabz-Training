import java.util.*;

public class LongestBalancedSubstringI {
    public int longestBalanced(String s) {
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            HashMap<Character, Integer> map=new HashMap<>();
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);
                if(check(map)){
                    max=Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    public boolean check(HashMap<Character, Integer> map){
        int x=0;
        for(int c:map.values()){
            if(c==0){
                continue;
            }
            if(x==0){
                x=c;
            }
            else if(x!=c){
                return false;
            }
        }
        return true;
    }
}