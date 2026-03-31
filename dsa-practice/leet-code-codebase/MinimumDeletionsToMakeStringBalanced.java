import java.util.*;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int c=0;
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)=='a' && st.peek()=='b'){
                st.pop();
                c++;
            }
            else{
                st.push(s.charAt(i));
            }
           
        }
        return c;
    }
}
