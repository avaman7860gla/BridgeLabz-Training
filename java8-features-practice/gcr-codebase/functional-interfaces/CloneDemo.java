class Employee implements Cloneable {
    int empId;
    String name;

    // constructor
    Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    // Overriding clone()
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void display() {
        System.out.println(empId + " , " + name);
    }
}

public class CloneDemo {
    public static void main(String[] args) {

        try {
            Employee emp1 = new Employee(201, "Aman");
            // clone
            Employee emp2 = (Employee) emp1.clone();

            System.out.println("Original Object:");
            emp1.display();

            System.out.println("Cloned Object:");
            emp2.display();

        } 
        catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}
