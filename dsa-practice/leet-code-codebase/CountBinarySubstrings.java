public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int pre=0;
        int c=1;
        int ans=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c++;
            }
            else{
                pre=c;
                c=1;
            }

            if(c<=pre){
                ans++;
            }
        }
        return ans;
    }
}