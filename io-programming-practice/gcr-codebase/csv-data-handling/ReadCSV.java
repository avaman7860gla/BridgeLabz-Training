import java.io.BufferedReader; 
import java.io.FileReader;     
import java.io.IOException;    

public class ReadCSV {

    public static void main(String[] args) {

        // path of the CSV file
        String filePath = "students.csv";

        String line;

        // try catch block
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // read and ignore the first line
            br.readLine();

            System.out.println("Student Records:");

            // read file line by line 
            while ((line = br.readLine()) != null) {

                // split the line using comma
                String[] data = line.split(",");

                // extract and convert data
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                // print student details
                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Age   : " + age);
                System.out.println("Marks : " + marks);

                System.out.println();
            }

        } 
        catch (IOException e) {
            // Handles file reading errors
            System.out.println("Error while reading the CSV file");
            e.printStackTrace();
        }
    }
}
