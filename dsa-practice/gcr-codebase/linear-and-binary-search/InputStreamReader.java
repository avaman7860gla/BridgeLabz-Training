import java.io.*;

public class InputStreamReader {
    public static void main(String[] args) {

        // filename to find path
        String filename = "input.txt";

        // use try and catch block
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
