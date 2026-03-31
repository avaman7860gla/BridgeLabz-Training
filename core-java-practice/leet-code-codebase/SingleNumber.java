public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x=nums[0];
        int i=0;
        while(i<nums.length-1){
            x=x^nums[i+1];
            i++;
        }
        return x;
    }
}