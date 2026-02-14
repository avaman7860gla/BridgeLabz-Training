import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Enrollment{
    private String name;
    private String courseName;
    private String courseCategory;
    private LocalDate enrollmentDate;

    // Constructor
    public Enrollment(String name, String courseName, String courseCategory, LocalDate enrollmentDate){
        this.name=name;
        this.courseName=courseName;
        this.courseCategory=courseCategory;
        this.enrollmentDate=enrollmentDate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    // Override toString method
    @Override
    public String toString() {
        return name + " enrolled in " + courseName + " [" + courseCategory + "] on " + enrollmentDate;
    }
}

class EnrollmentManager{
    private List<Enrollment> enrollments=new ArrayList<>();

    // Method to add enrollments
    public void addEnrollment(Enrollment e){
        enrollments.add(e);
    }

    // Method to filter list by course
    public List<Enrollment> filterByCourse(String courseName){
        return enrollments.stream().filter(e->e.getCourseName().equalsIgnoreCase(courseName))
                .collect(Collectors.toList());
    }

    // Method to filter list by course category
    public List<Enrollment> filterByCategory(String category){
        return enrollments.stream().filter(e->e.getCourseCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Method to make group of course
    public Map<String, List<Enrollment>> groupByCourse(){
        return enrollments.stream().collect(Collectors.groupingBy(Enrollment::getCourseName));
    }

    // Method to count by category
    public Map<String, Long> countByCategory(){
        return enrollments.stream().collect(Collectors.groupingBy(Enrollment::getCourseCategory,
                Collectors.counting()));
    }

    // Method to sort by date
    public List<Enrollment> sortByDate(){
        return enrollments.stream().sorted(Comparator.comparing(Enrollment::getEnrollmentDate))
                .collect(Collectors.toList());
    }
}

public class OnlineCourseEnrollmentManager {
    public static void main(String[] args) {
        EnrollmentManager manager = new EnrollmentManager();

        manager.addEnrollment(new Enrollment("Aman", "Java Full Stack", "Programming", LocalDate.of(2026, 2, 10)));
        manager.addEnrollment(new Enrollment("Priya", "Python Basics", "Programming", LocalDate.of(2026, 2, 12)));
        manager.addEnrollment(new Enrollment("Rahul", "Digital Marketing", "Marketing", LocalDate.of(2026, 2, 11)));
        manager.addEnrollment(new Enrollment("Sneha", "Java Full Stack", "Programming", LocalDate.of(2026, 2, 13)));

        System.out.println("Filter by Course (Java Full Stack):");
        manager.filterByCourse("Java Full Stack").forEach(System.out::println);

        System.out.println("\nFilter by Category (Programming):");
        manager.filterByCategory("Programming").forEach(System.out::println);

        System.out.println("\nGroup by Course:");
        manager.groupByCourse().forEach((course, list) -> {
            System.out.println(course + " -> " + list);
        });

        System.out.println("\nCount by Category:");
        manager.countByCategory().forEach((cat, count) -> {
            System.out.println(cat + " : " + count);
        });

        System.out.println("\nSorted by Enrollment Date:");
        manager.sortByDate().forEach(System.out::println);
    }
}

