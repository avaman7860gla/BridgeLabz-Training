import java.lang.reflect.*;

class Employee {
    public String name;
    public int age;

    public Employee() {}
    public Employee(String name, int age) {}
}

public class GetClassInformation {

    public static void main(String[] args) throws ClassNotFoundException {

        // get Class object
        Class<?> cls = Class.forName("Employee");

        // print class name
        System.out.println("Class Name: " + cls.getName());

        // print constructors
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            System.out.println(c);
        }

        // print fields
        System.out.println("\nFields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        // print methods
        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}
