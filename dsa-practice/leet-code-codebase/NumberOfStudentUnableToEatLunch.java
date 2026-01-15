public class NumberOfStudentUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int c=0;
        int s=0;
        for(int i:students){
            if(i==0){
                c++;
            }
            else{
                s++;
            }
        }
        for(int i:sandwiches){
            if(i==0 && c==0){
                return s;
            }
            if(i==1 && s==0){
                return c;
            }
            if(i==0){
                c--;
            }
            else{
                s--;
            }
        }
        return 0; 
    }
}