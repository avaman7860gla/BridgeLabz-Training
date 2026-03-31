package code;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class User {

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class JavaListToJsonArray {

    public static void main(String[] args) {

        // create java objects
        List<User> users = new ArrayList<>();
        users.add(new User("Aman", 20));
        users.add(new User("Riya", 30));
        users.add(new User("Amit", 40));

        // convert list to json array
        JSONArray jsonArray = new JSONArray();

        for (User user : users) {
            JSONObject obj = new JSONObject();
            obj.put("name", user.name);
            obj.put("age", user.age);
            jsonArray.put(obj);
        }

        // print json array
        System.out.println(jsonArray.toString(4));
    }
}

