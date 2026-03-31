import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementsInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        int size=nums.length;
        int n=size/2;

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<size;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()==n)
                return e.getKey();
        }
        return 0;

        
    }
}