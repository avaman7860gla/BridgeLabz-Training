import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        for(int n:arr){
            int x=1;
            while(!st.isEmpty() && n<0 && st.peek()>0){
                if(st.peek()<Math.abs(n)){
                    st.pop();
                    continue;
                }
                else if(Math.abs(n)==st.peek()){
                    st.pop();
                }
                x=0;
                break;
            }
            if(x!=0){
                st.push(n);
            }
        }
        int[]ans=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}
