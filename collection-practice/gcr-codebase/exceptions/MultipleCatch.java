public class MultipleCatch {
    public static void main(String[] args) {
        // empty array
        int[] arr = null;
        int index = 5;
        // exception handling with multiple catch block
        try {
            System.out.println("Value at index " + index + " = " + arr[index]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } 
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}