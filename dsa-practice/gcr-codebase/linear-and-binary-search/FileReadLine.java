import java.io.*;

public class FileReadLine {
    public static void main(String[] args) {

        // filename to find path
        String filename = "hello.txt";

        // use try catch block
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
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
