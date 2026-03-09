import java.util.*;

public class Find_Kth_In_Nth_BinaryString {
    public char findKthBit(int n, int k) {
        String s="0";
        for(int i=1;i<=n;i++){
            s=s+"1"+reverse(invert(s));
        }
        return s.charAt(k-1);
    }

    public String invert(String s){
        StringBuilder str=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch!='0'){
                str.append('0');
            }
            else{
                str.append('1');
            }
        }
        return str.toString();
    }

    public String reverse(String s){
        StringBuilder str=new StringBuilder(s);
        return str.reverse().toString();
    }
}