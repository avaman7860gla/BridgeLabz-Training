import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Student {
    private int id;
    private String name;

    public Student() {}
}

public class CustomObjectMapper {

    // generic method to map properties
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {

        // create object dynamically
        T obj = clazz.getDeclaredConstructor().newInstance();

        // loop through map and set values
        for (Map.Entry<String, Object> entry : properties.entrySet()) {

            Field field = clazz.getDeclaredField(entry.getKey());
            // allow access to private fields
            field.setAccessible(true);     
            field.set(obj, entry.getValue());
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Class<Student> cls = Student.class;
        // creating map
        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "Rahul");

        // mapping data to object
        Student student = toObject((Class<Student>) cls, data);

        System.out.println("Object created successfully using reflection");
    }
}
