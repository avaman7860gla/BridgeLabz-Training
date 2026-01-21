package code;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CensorJson {

    public static void main(String[] args) {

        try {
            // read json file
            JSONArray matches = new JSONArray(new JSONTokener(new FileReader("src/main/java/code/jsonInput.json")));

            JSONArray censoredMatches = new JSONArray();

            // process each match
            for (int i = 0; i < matches.length(); i++) {

                JSONObject match = matches.getJSONObject(i);

                match.put("team1",Censor.maskTeamName(match.getString("team1")));
                match.put("team2",Censor.maskTeamName(match.getString("team2")));
                match.put("playerOfMatch",Censor.redactPlayer());

                censoredMatches.put(match);
            }

            // write censored json
            FileWriter writer = new FileWriter("src/main/java/code/censoredJson.json");
            writer.write(censoredMatches.toString(4));
            writer.close();

            System.out.println("Censored JSON file generated");

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

