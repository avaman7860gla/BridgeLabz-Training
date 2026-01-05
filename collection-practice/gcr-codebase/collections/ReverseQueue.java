import java.util.*;

public class ReverseQueue {
    // method for reverse queue
    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) 
            return queue;
        T item = queue.remove();
        reverseQueue(queue);
        queue.add(item);
        return queue;
    }

    public static void main(String[] args) {
        // initialize queue
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);

        // function calling and display
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
