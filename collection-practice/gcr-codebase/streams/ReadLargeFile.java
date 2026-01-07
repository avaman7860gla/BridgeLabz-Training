import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {

        // read files
        try (BufferedReader reader = new BufferedReader(new FileReader("largefile.log"))) {
            String line;
            // check which line contains "error"
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}