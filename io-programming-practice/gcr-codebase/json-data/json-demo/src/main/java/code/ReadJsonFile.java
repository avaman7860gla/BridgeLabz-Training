package code;

import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadJsonFile {

    public static void main(String[] args) {

        try {
            // read json file
            FileReader reader = new FileReader("src/main/java/code/user.json");
            
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);

            // extract required fields
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            // print data
            System.out.println("Name  : " + name);
            System.out.println("Email : " + email);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

