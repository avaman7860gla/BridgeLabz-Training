import java.util.*;

public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int max=0;
        int height[]=new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    height[j]+=1;
                }
                else{
                    height[j]=0;
                }
            }

            int []arr=height.clone();
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));

            for(int j=0;j<n;j++){
                int h=arr[n-1-j];
                max=Math.max(max, h*(j+1));
            }
        }
        return max;
    }   
}
