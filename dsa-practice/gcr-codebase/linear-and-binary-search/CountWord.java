import java.io.*;

public class countword {
    public static void main(String[] args) {
        String filename = "input.txt"; // file path in which we have to find
        String target = "the"; // target word to find in file
        int count = 0;

        // use try and catch block
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) 
                        count++;
                }
            }
            System.out.println("Count of " + target + " is " + count); // print count
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
