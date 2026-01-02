
public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            String s=operations[i];
            if(!s.equals("C") && !s.equals("D") && !s.equals("+")){
                st.push(Integer.parseInt(s));
            }
            else if(s.equals("C")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else if(s.equals("D")){
                if(!st.isEmpty()){
                    st.push(2*st.peek());
                }
            }
            else if(s.equals("+")){
                if(st.size()>=2){
                    int x1=st.pop();
                    int x2=st.pop();
                    st.push(x2);
                    st.push(x1);
                    st.push(x1+x2);
                }
            }

        }  
        int sum=0;
        while(!st.isEmpty()){
            sum=sum+st.pop();
        }
        return sum;
    }
}