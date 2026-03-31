class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int n=x;
        int r,s=0;
        while(x>0){
            r=x%10;
            s=s*10+r;
            x=x/10;
        }
        if(s==n){
            return true;
        }
        return false;
    }
}