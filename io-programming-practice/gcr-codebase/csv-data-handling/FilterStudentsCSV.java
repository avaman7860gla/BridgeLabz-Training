import java.io.BufferedReader;  
import java.io.FileReader;     
import java.io.IOException;   

public class FilterStudentsCSV {

    public static void main(String[] args) {

        // path of the CSV file
        String filePath = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            System.out.println("Students scoring more than 80 marks:");

            // read file line by line
            while ((line = br.readLine()) != null) {

                // split CSV line
                String[] data = line.split(",");

                // extract values
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                // apply filter
                if (marks > 80) {
                    System.out.println("ID    : " + id);
                    System.out.println("Name  : " + name);
                    System.out.println("Age   : " + age);
                    System.out.println("Marks : " + marks);
                    System.out.println();
                }
            }

        } 
        catch (IOException e) {
            // handle file-related errors
            System.out.println("Error while filtering student records.");
            e.printStackTrace();
        }
    }
}
