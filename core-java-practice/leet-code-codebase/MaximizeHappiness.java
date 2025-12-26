import java.util.Arrays;

public class MaximizeHappiness {
    public long maximumHappinessSum(int[] arr, int k) {
        Arrays.sort(arr);
        int i=arr.length-1;
        int j=0;
        long ans=0;
        while(k-->0){
            if(arr[i]-j>0){
                ans=ans+arr[i]-j;
            }
            i--;
            j++;
        }
        return ans;
    }
}
