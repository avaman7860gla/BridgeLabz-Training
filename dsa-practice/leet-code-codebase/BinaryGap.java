public class BinaryGap {
    public int binaryGap(int n) {
        int dist = -1;
        int maxGap = 0;
        while(n > 0) {
            if((n & 1) != 0) {
                dist++;
                maxGap = Math.max(maxGap, dist);
                dist = 0;
            }
            else if(dist != -1) {
                dist++;
            }
            n = n >> 1;
        }
        return maxGap;
    }
}