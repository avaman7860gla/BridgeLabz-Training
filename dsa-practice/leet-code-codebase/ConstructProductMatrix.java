import java.util.*;

public class ConstructProductMatrix {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int size=m*n;
        int idx=0;
        int mod=12345;

        int[]arr=new int[size];

        for(int[]row:grid){
            for(int val:row){
                arr[idx++]=val%mod;
            }
        }

        int[]pre=new int[size];
        pre[0]=1;
        for(int i=1;i<size;i++){
            pre[i]=(pre[i-1]*arr[i-1])%mod;
        }

        int[]suff=new int[size];
        suff[size-1]=1;
        for(int i=size-2;i>=0;i--){
            suff[i]=(suff[i+1]*arr[i+1])%mod;
        }

        int[][]res=new int[n][m];
        idx=0;
        for(int i=0;i<size;i++){
            res[i/m][i%m]=(pre[i]*suff[i])%mod;
        }
        return res;
    }   
}
