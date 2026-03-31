import java.io.*;

public class CheckedException {
    public static void main(String[] args) {
        // read a file which i dont created
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } 
        // handle that exception 
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
}