import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {

    public static void main(String[] args) {

        Map<String, String> marksData = new HashMap<>();
        String line;

        // try catch block
        try {
            // read second file into map
            BufferedReader br2 = new BufferedReader(new FileReader("student2.csv"));
            br2.readLine();

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                marksData.put(data[0], data[1] + "," + data[2]);
            }
            br2.close();

            // read first file and merge
            BufferedReader br1 = new BufferedReader(new FileReader("student1.csv"));
            FileWriter writer = new FileWriter("merged_students.csv");

            writer.write("ID,Name,Age,Marks,Grade\n");
            br1.readLine();

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (marksData.containsKey(id)) {
                    writer.write(line + "," + marksData.get(id) + "\n");
                }
            }

            br1.close();
            writer.close();

            System.out.println("CSV files merged successfully");

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
