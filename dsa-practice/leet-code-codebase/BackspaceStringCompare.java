import java.util.*;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>st1=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='#' && !st1.isEmpty()){
                st1.pop();
            }
            else if(ch!='#'){
                st1.push(ch);
            }
        }
        StringBuilder str1=new StringBuilder();
        while(!st1.isEmpty()){
            str1.append(st1.pop());
        }
        String ans1=str1.reverse().toString();
        Stack<Character>st2=new Stack<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(ch=='#' && !st2.isEmpty()){
                st2.pop();
            }
            else if(ch!='#'){
                st2.push(ch);
            }
        }
        StringBuilder str2=new StringBuilder();
        while(!st2.isEmpty()){
            str2.append(st2.pop());
        }
        String ans2=str2.reverse().toString();
        return ans1.equals(ans2);
    }
}
