public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length - 1;
        int a=0;
        while (r>l){
            int currentArea=Math.min(height[l],height[r])*(r-l);
            a=Math.max(a,currentArea);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return a;
    }
}
