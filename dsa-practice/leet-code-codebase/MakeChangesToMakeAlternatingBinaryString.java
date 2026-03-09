import java.util.*;

public class MakeChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int c0=0;
        int c1=0;
        int min=0;
        for(int i=0;i<s.length();i++){
            char ch0='0';
            char ch1='0';
            if(i%2==0){
                ch0='0';
            }
            else{
                ch0='1';
            }

            if(i%2==0){
                ch1='1';
            }
            else{
                ch1='0';
            }

            if(s.charAt(i)!=ch0){
                c0++;
            }
            else{
                c1++;
            }
        }
        return Math.min(c0, c1);
    }
}