package code;

import java.io.FileReader;
import java.util.Iterator;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadAllKeysValues {

    public static void main(String[] args) {

        try {
            // read json file
            FileReader reader = new FileReader("src/main/java/code/user.json");
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            // iterate over all keys
            Iterator<String> keys = jsonObject.keys();

            // print all key value pairs
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                System.out.println(key + " : " + value);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

