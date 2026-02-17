import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list=new ArrayList<>();
        if(turnedOn>=9){
            return list;
        }
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                int bits=Integer.bitCount(i)+Integer.bitCount(j);
                if(bits==turnedOn){
                    list.add(i+":"+String.format("%02d", j));
                }
            }
        }
        return list;
    }
}