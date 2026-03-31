import java.util.HashMap;
import java.util.Map;
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        for(int f:map.values()){
            max=Math.max(max,f);
        }
        int ans=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)==max){
                int l=0;
                int r=nums.length-1;
                while(l<=r){
                    if(nums[l]==key){
                        break;
                    }
                    l++;
                }
                while(l<r){
                    if(nums[r]==key){
                        break;
                    }
                    r--;
                }
                ans=Math.min(ans,r-l+1);
            }
        }
        return ans;
    }
}