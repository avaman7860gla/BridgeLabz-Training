
public class ArithExceptionDemo {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;

            System.out.println("output: " + result);
        } 
        catch (ArithmeticException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

    }
}
