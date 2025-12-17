class removeElements {
    public int removeElement(int[] nums, int val) {
        int c=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=val){
                nums[c]=nums[i];
                c++;
            }
        }
        return c;
    }
}