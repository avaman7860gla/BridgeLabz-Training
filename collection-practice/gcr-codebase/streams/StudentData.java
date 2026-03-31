import java.io.*;

public class StudentData {
    public static void main(String[] args) {
        String file = "students.dat";

        // write data to students.dat file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.9);
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        // read data
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println(roll + " " + name + " " + gpa);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}