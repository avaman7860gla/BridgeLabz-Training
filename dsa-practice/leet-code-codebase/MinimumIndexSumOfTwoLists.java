import java.util.ArrayList;
import java.util.List;
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i].equals(list2[j])){
                    if(i+j<=min){
                        if(i+j<min){
                            list.clear();
                            min=i+j;
                        }
                        list.add(list1[i]);
                    }
                    break;   
                }
            }
        }
        String[] ans=new String[list.size()];
        int i=0;
        for(String s:list){
            ans[i++]=s;
        }
        return ans;
    }
}