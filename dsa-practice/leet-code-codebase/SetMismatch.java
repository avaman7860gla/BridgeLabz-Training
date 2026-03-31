import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()>1){
                list.add(e.getKey());
            }
        }
        int actSum=0;
        int rep=list.get(0);
        for(int i=0;i<n;i++){
            actSum+=nums[i];
        }
        int expSum=n*(n+1)/2;

        list.add(expSum-(actSum-rep));
        int[] ans=new int[list.size()];
        int i=0;
        for(int x:list){
            ans[i++]=x;
        }
        return ans;
    }
}