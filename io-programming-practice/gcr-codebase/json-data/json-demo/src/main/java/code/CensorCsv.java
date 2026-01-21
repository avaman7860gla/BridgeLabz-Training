package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CensorCsv {

    public static void main(String[] args) {

        try (
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/code/csvInput.csv"));
            FileWriter writer = new FileWriter("src/main/java/code/CensoredCsv.csv")
        ) {

            // write header
            writer.write(br.readLine() + "\n");

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                data[1] = Censor.maskTeamName(data[1]);
                data[2] = Censor.maskTeamName(data[2]);
                data[3] = Censor.redactPlayer();

                writer.write(String.join(",", data) + "\n");
            }

            System.out.println("Censored CSV file generated");

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

