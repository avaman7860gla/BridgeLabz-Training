import java.util.Stack;
public class RPN {
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(String str:tokens){
            if(!st.isEmpty() && str.equals("+")){
                int a=Integer.parseInt(st.pop());
                int b=Integer.parseInt(st.pop());
                int sum=a+b;
                st.push(Integer.toString(sum));
            }
            else if(!st.isEmpty() && str.equals("*")){
                int a=Integer.parseInt(st.pop());
                int b=Integer.parseInt(st.pop());
                int pro=a*b;
                st.push(Integer.toString(pro));
            }
            else if(!st.isEmpty() && str.equals("/")){
                int a=Integer.parseInt(st.pop());
                int b=Integer.parseInt(st.pop());
                int div=b/a;
                st.push(Integer.toString(div));
            }
            else if(!st.isEmpty() && str.equals("-")){
                int a=Integer.parseInt(st.pop());
                int b=Integer.parseInt(st.pop());
                int sub=b-a;
                st.push(Integer.toString(sub));
            }
            
            
            else st.push(str);
        }
        return Integer.parseInt(st.pop());
    }
    
}