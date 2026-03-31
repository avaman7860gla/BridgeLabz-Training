import java.util.Stack;

public class MyQueue {

    // Two stacks- for input and output
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    // Add an element to the queue
    public void enqueue(int x) {
        input.push(x);
    }

    // Remove and return the front element
    public int dequeue() {
        // If output stack is empty, transfer all elements from input
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        // If output is still empty, queue is empty
        if(output.isEmpty()){
            return -1;
        }
        return output.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); 
        System.out.println("Dequeued: " + queue.dequeue()); 

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue()); 
        System.out.println("Dequeued: " + queue.dequeue()); 

        // Check if queue is empty
        System.out.println(queue.isEmpty());
    }
}
