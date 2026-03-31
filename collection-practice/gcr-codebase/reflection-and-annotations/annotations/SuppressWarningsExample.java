import java.util.ArrayList;

public class SuppressWarningsExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // raw type arraylist
        ArrayList list = new ArrayList(); 

        // add elements to list
        list.add("Java");
        list.add(100);

        System.out.println(list);
    }
}
