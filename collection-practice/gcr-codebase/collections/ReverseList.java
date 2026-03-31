import java.util.*;

public class ReverseList {

    // method for reverse list
    public static <T> void reverseList(List<T> list) {
        // using two pointer approach
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // initialize arraylist and linkedlist
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> linkedList = new LinkedList<>(arrayList);

        // function calling
        reverseList(arrayList);
        reverseList(linkedList);

        // display output
        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
