public class Course {

    // Instance variables
    String courseName;
    int duration;
    double fee;

    // Static variable
    static String instituteName = "ABC Institute";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Method to display course details
    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: ₹" + fee + ", Institute: " + instituteName);
    }

    // Static method to update institute name
    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        // Creating Course objects
        Course c1 = new Course("Java Programming", 3, 15000);
        Course c2 = new Course("Web Development", 4, 18000);

        // Displaying course details
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        System.out.println("After updating institute name :-");
        // Updating institute name
        Course.updateInstituteName("XYZ Academy");

        // Displaying course details again to reflect updated institute name
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
