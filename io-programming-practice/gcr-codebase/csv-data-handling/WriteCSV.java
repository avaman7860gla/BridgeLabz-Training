import java.io.FileWriter;  
import java.io.IOException; 

public class WriteCSV {

    public static void main(String[] args) {

        // path where CSV file will be created
        String filePath = "employees.csv";

        // try ctach block
        try (FileWriter writer = new FileWriter(filePath)) {

            // writing CSV column headers
            writer.append("ID,Name,Department,Salary\n");

            // writing employee records
            writer.append("101,Rahul,HR,45000\n");
            writer.append("102,Priya,IT,60000\n");
            writer.append("103,Aman,Finance,55000\n");
            writer.append("104,Neeta,Marketing,48000\n");
            writer.append("105,Suresh,Operations,52000\n");

            // confirmation message
            System.out.println("Employee CSV file created successfully");

        } 
        catch (IOException e) {
            // handles file writing errors
            System.out.println("Error while writing to the CSV file");
            e.printStackTrace();
        }
    }
}
