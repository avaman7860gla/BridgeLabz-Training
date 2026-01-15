import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// annotation to restrict maximum string length
@Retention(RetentionPolicy.RUNTIME)     
@Target(ElementType.FIELD)               
@interface MaxLength {
    int value();                         
}

class User {

    @MaxLength(10)
    private String username;

    // constructor validates length
    public User(String username) {

        try {
            // get field object
            var field = this.getClass().getDeclaredField("username");

            // check if @MaxLength is present
            if (field.isAnnotationPresent(MaxLength.class)) {

                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                // validate length
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value());
                }
            }

            this.username = username;
        } 
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}


public class MaxLengthExample {

    public static void main(String[] args) {

        // valid username
        User user1 = new User("Aman");
        System.out.println("Username: " + user1.getUsername());

        // invalid username
        User user2 = new User("VeryLongUsername");  // this throws exception
    }
}
