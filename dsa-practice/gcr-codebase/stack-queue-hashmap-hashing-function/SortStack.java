import java.util.Stack;

public class SortStack {

    // Recursive function to sort
    public static void sort(Stack<Integer> stack) {
        // Base case
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();

            // Recursive call
            sort(stack);

            // Insert the removed element back in sorted order
            insertSorted(stack, top);
        }
    }

    // Function to insert an element into the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } 
        else {
            // Pop the top and recurse until correct position is found
            int top = stack.pop();
            insertSorted(stack, element);

            // Push the stored top back after inserting element
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);
        // Function call
        sort(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
