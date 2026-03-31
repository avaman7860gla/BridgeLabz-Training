import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

    // method to add
    public int add(int a, int b) {
        return a + b;
    }

    // method to subtract
    public int subtract(int a, int b) {
        return a - b;
    }

    // method to multiply
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        MathOperations obj = new MathOperations();

        // get Class object
        Class<?> cls = obj.getClass();

        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.next();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // getting method dynamically
        Method method = cls.getMethod(methodName, int.class, int.class);

        // invoking method dynamically
        Object result = method.invoke(obj, a, b);

        // print result
        System.out.println("Result: " + result);

    }
}
