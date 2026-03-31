import java.lang.reflect.Method;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.METHOD)           
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {

    @ImportantMethod
    public void processData() {
        System.out.println("Processing data");
    }

    @ImportantMethod(level = "MEDIUM")
    public void validateData() {
        System.out.println("Validating data");
    }

    public void helperMethod() {
        System.out.println("Helper method");
    }
}

public class ImportantMethodExample {

    public static void main(String[] args) {

        Service service = new Service();

        // getting class object
        Class<?> cls = service.getClass();

        // getting all methods of the class
        Method[] methods = cls.getDeclaredMethods();

        System.out.println("Important Methods:");

        for (Method method : methods) {

            // check if method has @ImportantMethod annotation
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method Name: " + method.getName() +", Importance Level: " + annotation.level());
            }
        }
    }
}
