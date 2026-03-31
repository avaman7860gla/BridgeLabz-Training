package code;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateStudentJson {

    public static void main(String[] args) {

        // create json object
        JSONObject student = new JSONObject();

        // add fields
        student.put("name", "Amit");
        student.put("age", 20);

        // create json array
        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Physics");
        subjects.put("Computer Science");

        // add array to student object
        student.put("subjects", subjects);

        // print formatted json
        System.out.println(student.toString(4));
    }
}

