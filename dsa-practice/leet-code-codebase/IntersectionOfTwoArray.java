import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]) set.add(nums1[i]);
            }
        }
        List<Integer> list=new ArrayList<>(set);
        int[]ans=new int[list.size()];
        int i=0;
        for(int val:list){
            ans[i++]=val;
        }
        return ans;
    }
}
