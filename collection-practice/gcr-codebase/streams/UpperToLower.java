import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {

        // read input.txt file
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            // convert
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("Converted uppercase to lowercase.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}