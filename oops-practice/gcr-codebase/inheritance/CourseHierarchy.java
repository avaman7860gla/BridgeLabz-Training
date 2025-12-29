
class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void showDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}


class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // call parent constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void showDetails() {
        super.showDetails(); // reuse parent details
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded); // call constructor
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void showDetails() {
        super.showDetails(); // reuse parent details
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Fee: ₹" + fee + ", Discount: " + discount + "%, Final Fee: ₹" + finalFee);
    }
}


public class CourseHierarchy {
    public static void main(String[] args) {
        // Create a course
        Course course = new Course("Java Basics", 6);
        course.showDetails();

        System.out.println();

        // Create an online course
        OnlineCourse online = new OnlineCourse("Data Structures", 8, "Udemy", true);
        online.showDetails();

        System.out.println();

        // Create a paid online course
        PaidOnlineCourse paid = new PaidOnlineCourse("System Design", 12, "Coursera", false, 5000.0, 20.0);
        paid.showDetails();
    }
}
