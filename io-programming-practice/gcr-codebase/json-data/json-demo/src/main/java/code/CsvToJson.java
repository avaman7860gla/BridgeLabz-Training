package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class CsvToJson {

    public static void main(String[] args) {

        String csvFile = "src/main/java/code/students.csv";
        String line;

        // json array
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // read the header row
            String headerLine = br.readLine();
            String[] headers = headerLine.split("\t");

            // read remaining rows
            while ((line = br.readLine()) != null) {

                String[] values = line.split("\t");

                // create json object for each row
                JSONObject jsonObject = new JSONObject();

                // map csv columns to json keys
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], values[i]);
                }

                // add json object to array
                jsonArray.put(jsonObject);
            }

            // print final json output
            System.out.println(jsonArray.toString(4));

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

