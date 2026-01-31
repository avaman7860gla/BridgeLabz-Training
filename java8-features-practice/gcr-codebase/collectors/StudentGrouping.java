import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String grade;

    // constructor
    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

public class StudentGrouping {
    public static void main(String[] args) {

        // list of students
        List<Student> students = List.of(
                new Student("Amit", "A"),
                new Student("Neha", "B"),
                new Student("Rahul", "A"),
                new Student("Riya", "C"),
                new Student("Priya", "B")
        );

        Map<String, List<String>> studentsByGrade =students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList()))
                                );

        studentsByGrade.forEach((grade, names)->System.out.println("Grade " + grade + " - " + names)
        );
    }
}
