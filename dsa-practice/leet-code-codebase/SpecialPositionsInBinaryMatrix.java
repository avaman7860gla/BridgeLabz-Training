import java.util.*;

public class SpecialPositionsInBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int c=0;
        int m=mat.length;
        int n=mat[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    int[]row=mat[i];
                    int[]col=new int[m]; 
                    for (int k=0;k<m;k++){ 
                        col[k]=mat[k][j];
                    }
                    if(check(row, col)){
                        c++;
                    }
                }
            }
        }
        return c;
    }

    public boolean check(int[] row, int[] col){
        int rc=0;
        for(int x:row){
            rc+=x;
        }

        int cc=0;
        for(int x:col){
            cc+=x;
        }

        return rc==1 && cc==1;
    }
}