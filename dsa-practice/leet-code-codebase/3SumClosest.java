import java.util.*;

public class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int x=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(target-x)>Math.abs(target-sum)){
                    x=sum;
                }
                if(target<sum){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return x;
    }
}
