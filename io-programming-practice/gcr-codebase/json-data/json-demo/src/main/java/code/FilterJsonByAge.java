package code;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterJsonByAge {

    public static void main(String[] args) {

        // sample json array
        JSONArray users = new JSONArray();

        users.put(new JSONObject().put("name", "Amit").put("age", 20));
        users.put(new JSONObject().put("name", "Riya").put("age", 30));
        users.put(new JSONObject().put("name", "Kunal").put("age", 35));

        System.out.println("Users older than 25:");

        // filter users
        for (int i = 0; i < users.length(); i++) {

            JSONObject user = users.getJSONObject(i);
            int age = user.getInt("age");

            // print users
            if (age > 25) {
                System.out.println(user);
            }
        }
    }
}

