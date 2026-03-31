import java.io.BufferedReader;  
import java.io.FileReader;      
import java.io.IOException;     
import java.util.Scanner;      

public class SearchEmployeeCSV {

    public static void main(String[] args) {

        // CSV file path
        String filePath = "employees.csv";
        String line;
        boolean found = false;

        Scanner scanner = new Scanner(System.in);
        // user input
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            // read file line by line
            while ((line = br.readLine()) != null) {

                // split the line by comma
                String[] data = line.split(",");

                String name = data[1];

                // compare names
                if (name.equalsIgnoreCase(searchName)) {

                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);

                    System.out.println("\nEmployee Found:");
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);

                    found = true;
                    break;
                }
            }

            // if not found
            if (!found) {
                System.out.println("\nEmployee not found");
            }

        } 
        catch (IOException e) {
            // handle file errors
            System.out.println("Error while searching employee");
            e.printStackTrace();
        }
    }
}
