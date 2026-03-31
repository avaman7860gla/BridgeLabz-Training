class Student {
    // Attributes with different access modifiers
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor to initialize the attributes
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Getter and Setter for private attribute CGPA
    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

// Subclass to demonstrate inheritance and access to superclass members
public class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", CGPA: " + getCGPA());
    }

    public static void main(String[] args) {
        // Create an instance of PostgraduateStudent and display details
        PostgraduateStudent pg = new PostgraduateStudent(101, "Alice", 8.7);
        pg.displayDetails();
        pg.setCGPA(9.1);

        
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
