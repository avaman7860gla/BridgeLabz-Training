public class rotationpoint {
    public static int findRotationPoint(int[] arr) {

        // use binary search to find rotational point index
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) 
                left = mid + 1;
            else 
                right = mid;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        // display index
        System.out.println("Rotation point index: " + findRotationPoint(arr));
    }
}
