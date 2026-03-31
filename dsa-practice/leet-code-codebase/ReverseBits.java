import java.util.*;

public class ReverseBits {
    public int reverseBits(int n) {
        String bin=Integer.toBinaryString(n);
        String pad=String.format("%32s",bin).replace(' ','0');
        StringBuilder str=new StringBuilder(pad);
        String ans=str.reverse().toString();
        return Integer.parseInt(ans,2);
    }
}