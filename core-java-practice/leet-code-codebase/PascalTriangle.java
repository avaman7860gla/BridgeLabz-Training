import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>list1= new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer>list=new ArrayList<>();
            int nCr=1;
            for(int j=0;j<=i;j++){
                list.add(nCr);
                nCr=((i-j)*nCr)/(j+1);
            }
            list1.add(list);
        }
        return list1;
    }
}