import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// annotated class
@Author(name = "Aman Verma")
class Book {
}

public class RetrieveAnnotation {

    public static void main(String[] args) throws Exception {

        // get class object
        Class<?> cls = Class.forName("Book");

        // check if annotation is present
        if (cls.isAnnotationPresent(Author.class)) {

            // retrieve annotation
            Author author = cls.getAnnotation(Author.class);

            // display annotation value
            System.out.println("Author Name: " + author.name());
        }
    }
}

