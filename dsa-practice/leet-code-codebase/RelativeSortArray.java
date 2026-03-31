public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001]; 
        int[] result = new int[arr1.length];
        int k = 0;
        for (int x : arr1) {
            freq[x]++;
        }
        for (int x : arr2) {
            while (freq[x] > 0) {
                result[k++] = x;
                freq[x]--;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                result[k++] = i;
                freq[i]--;
            }
        }
        return result;
    }
}