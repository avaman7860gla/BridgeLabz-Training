import java.lang.reflect.Field;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}


public class ObjectToJson {

    public static void main(String[] args) throws Exception {

        Product product = new Product(1, "Laptop", 55000.50);

        // getting class object
        Class<?> cls = product.getClass();

        // fields to json
        Field[] fields = cls.getDeclaredFields();
        StringBuilder json = new StringBuilder("{");

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            json.append("\"")
                .append(fields[i].getName())
                .append("\": \"")
                .append(fields[i].get(product))
                .append("\"");

            if (i < fields.length - 1) {
                json.append(", ");
            }
        }

        json.append("}");

        // display json
        System.out.println("Json Output:");
        System.out.println(json.toString());
    }
}
