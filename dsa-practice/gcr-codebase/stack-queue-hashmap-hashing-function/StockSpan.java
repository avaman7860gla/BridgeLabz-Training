import java.util.Stack;
import java.util.Arrays;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        Stack<Integer> stack = new Stack<>(); 
        int[] span = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
           
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices are smaller
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } 
            else {
                // Span is distance between current day and last higher price
                span[i] = i - stack.peek();
            }

            // Push current index 
            stack.push(i);
        }

        return span;
    }

    
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = calculateSpan(prices);

        System.out.println("Span Values: " + Arrays.toString(span));
        
    }
}
