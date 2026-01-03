import java.util.Stack;
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>st=new Stack<>();
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums2){
            while(!st.isEmpty() && num>st.peek()){
                map.put(st.pop(),num);
            }
            st.push(num);
        }
        int[]ans=new int[nums1.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
