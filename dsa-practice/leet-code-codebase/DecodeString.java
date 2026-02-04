import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<String> st2=new Stack<>();

        String curr="";
        int currNum=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                currNum=currNum*10+(c-'0');
            }
            else if(c=='['){
                st1.push(currNum);
                st2.push(curr);
                curr="";
                currNum=0;
            }
            else if(c==']'){
                int rep=st1.pop();
                String prev=st2.pop();
                StringBuilder sb=new StringBuilder(prev);
                for(int i=0;i<rep;i++){
                    sb.append(curr);
                }
                curr=sb.toString();
            }
            else{
                curr+=c;
            }
        }
        return curr;
    }
}