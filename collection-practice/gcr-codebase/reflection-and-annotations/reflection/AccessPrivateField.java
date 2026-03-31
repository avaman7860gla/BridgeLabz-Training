import java.lang.reflect.Field;

class Person {
    private int age = 21;
}

public class AccessPrivateField {

    public static void main(String[] args) throws Exception {

        // create object
        Person person = new Person();

        // get class object
        Class<?> cls = person.getClass();

        // access private field
        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);

        // modify and retrieve value
        ageField.set(person, 30);
        System.out.println("Updated Age: " + ageField.get(person));
    }
}
