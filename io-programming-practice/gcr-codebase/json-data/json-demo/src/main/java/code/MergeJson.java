package code;

import org.json.JSONObject;

public class MergeJson {

    public static void main(String[] args) {

        // first json object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Aman");
        json1.put("age", 20);

        // second json object
        JSONObject json2 = new JSONObject();
        json2.put("email", "aman@gmail.com");
        json2.put("city", "Pune");

        // merge json2 into json1
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        // print merged json
        System.out.println(json1.toString(4));
    }
}

