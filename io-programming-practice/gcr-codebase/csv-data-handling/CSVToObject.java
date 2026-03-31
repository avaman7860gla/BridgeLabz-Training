import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Student {
    int id;
    String name;
    int age;
    int marks;

    // constructor
    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    // toString method
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name +
               ", Age=" + age + ", Marks=" + marks + "]";
    }
}

public class CSVToObject {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        String line;

        // try catch block
        try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {

            br.readLine();

            // read each line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                students.add(s);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        // print student objects
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
