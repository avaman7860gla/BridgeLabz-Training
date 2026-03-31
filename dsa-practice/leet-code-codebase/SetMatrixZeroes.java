public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean flag1=false;
        boolean flag2=false;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                flag1=true;
            }
        }
        for(int j=0;j<m;j++){
            if(matrix[0][j]==0){
                flag2=true;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(flag1){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
        if(flag2){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
    }
}
