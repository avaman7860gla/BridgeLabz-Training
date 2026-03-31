public class Circle {

    // Instance variable
    double radius;

    // Default constructor
    Circle() {
        this(1.0);
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        // Creating Circle objects using both constructors
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.0);

        // Displaying areas
        System.out.println("Default Circle Area = " + c1.getArea());
        System.out.println("Custom Circle Area = " + c2.getArea());
    }
}
