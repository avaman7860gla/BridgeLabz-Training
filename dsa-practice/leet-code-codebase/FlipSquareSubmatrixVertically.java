import java.util.*;

public class FlipSquareSubmatrixVertically {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int t=x;
        int b=x+k-1;
        while(t<b){
            for(int i=y;i<y+k;i++){
                int temp=grid[t][i];
                grid[t][i]=grid[b][i];
                grid[b][i]=temp;
            }

            t++;
            b--;
        }
        return grid;
    }
}
