import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        // read a file which i not created
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            System.out.println("First line: " + br.readLine());
        } 
        // handle that exception
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}