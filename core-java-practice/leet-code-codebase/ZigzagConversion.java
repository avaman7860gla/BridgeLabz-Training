 
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        int r = 0;
        boolean d = false;
        for (char ch : s.toCharArray()) {
            arr[r].append(ch);
            if (r == 0 || r == numRows - 1) {
                if(d==true){
                    d=false;
                }
                else{
                    d=true;
                }
            }
            r += d ? 1 : -1;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder str : arr) {
            ans.append(str);
        }

        return ans.toString();
    }
}
