import java.util.*;

public class RotateList {

    // method to rotate list
    public static <T> void rotate(List<T> list, int k) {
        int n = list.size();
        k = k % n;
        if (k == 0) 
            return;

        List<T> temp = new ArrayList<>(list.subList(k, n));
        temp.addAll(list.subList(0, k));
        for (int i = 0; i < n; i++) {
            list.set(i, temp.get(i));
        }
    }

    public static void main(String[] args) {

        // initialize list
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotate(list, 2);  // method call
        System.out.println("Rotated List: " + list);   // display
    }
}
