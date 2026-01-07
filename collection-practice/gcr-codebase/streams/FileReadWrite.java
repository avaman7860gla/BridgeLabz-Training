import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {

        // input files
        File inputFile = new File("source.txt");
        File outputFile = new File("destination.txt");

        // check existance
        if (!inputFile.exists()) {
            System.out.println("file not exist.");
            return;
        }

        // exception handling
        try (FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}