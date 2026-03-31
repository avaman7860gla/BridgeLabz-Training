import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = 0;
            for (int i = 0; i < digits.length; i++) {
                n = n * 10 + digits[i];
            }
            n = n + 1;
            String s = "" + n;
            int[] plusOne = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                plusOne[i] = s.charAt(i) - '0';
            }
            System.out.println(Arrays.toString(plusOne));
            return plusOne;
    }
}