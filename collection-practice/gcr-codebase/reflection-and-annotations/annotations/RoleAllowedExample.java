import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// class-level annotation to restrict access based on role
@Retention(RetentionPolicy.RUNTIME)     
@Target(ElementType.TYPE)              
@interface RoleAllowed {
    String value();        
}

@RoleAllowed("ADMIN")
class AdminService {
    public void performAdminTask() {
        System.out.println("Admin task executed");
    }
}

public class RoleAllowedExample {

    // current user role
    static String currentUserRole = "USER";   // change this to "ADMIN" to allow access

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();

        // getting class object
        Class<?> cls = service.getClass();

        // check if @RoleAllowed annotation is present
        if (cls.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);

            // validate role before execution
            if (roleAllowed.value().equals(currentUserRole)) {
                service.performAdminTask();
            } 
            else {
                System.out.println("Access denied");
            }
        }
    }
}
