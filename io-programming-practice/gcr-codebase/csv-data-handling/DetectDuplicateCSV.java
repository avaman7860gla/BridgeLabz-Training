import java.io.BufferedReader;  
import java.io.FileReader;       
import java.io.IOException;      
import java.util.HashMap;        
import java.util.Map;

public class DetectDuplicateCSV {

    public static void main(String[] args) {

        String filePath = "abc.csv";
        String line;

        // map to store count of each ID
        Map<String, Integer> idCountMap = new HashMap<>();

        // map to store the actual row for each ID
        Map<String, String> recordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // skip CSV header
            br.readLine();

            // read CSV line by line
            while ((line = br.readLine()) != null) {

                // split the row
                String[] data = line.split(",");

                String id = data[0];

                // count occurrences of each ID
                idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);

                // store record 
                recordMap.put(id, line);
            }

            System.out.println("Duplicate Records Found:");

            boolean duplicateFound = false;

            // check for IDs that appears more than once
            for (String id : idCountMap.keySet()) {

                if (idCountMap.get(id) > 1) {
                    System.out.println("ID: " + id);
                    System.out.println("Record: " + recordMap.get(id));
                    duplicateFound = true;
                }
            }

            // if no duplicates exist
            if (!duplicateFound) {
                System.out.println("No duplicate records found");
            }

        } 
        catch (IOException e) {
            System.out.println("Error while reading CSV file");
            e.printStackTrace();
        }
    }
}
