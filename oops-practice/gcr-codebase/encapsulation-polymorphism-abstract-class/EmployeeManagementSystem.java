// abstract class employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // getter and setter methods
    public int getEmployeeId() { 
        return employeeId; 
    }
    public void setEmployeeId(int employeeId) { 
        this.employeeId = employeeId; 
    }


    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }


    public double getBaseSalary() { 
        return baseSalary; 
    }
    public void setBaseSalary(double baseSalary) { 
        this.baseSalary = baseSalary; 
    }

    // abstract method to calculate salary
    public abstract double calculateSalary();

    // method to display employee details
    public void displayDetails() {
        System.out.println("ID = " + employeeId + " Name = " + name + " Base Salary = " + baseSalary);
    }
}

// interface
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// full-time employee class
class FullTimeEmployee extends Employee implements Department {
    private String department;
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// part-time employee class
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    // constructor
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee(1, "Raj", 50000);
        employees[1] = new PartTimeEmployee(2, "Rohan", 200, 20);

        // assign departments
        ((Department)employees[0]).assignDepartment("HR");
        ((Department)employees[1]).assignDepartment("IT");

        // display employee details and salaries
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Salary = " + emp.calculateSalary());
            System.out.println(((Department)emp).getDepartmentDetails());
            System.out.println();
        }
    }
}
