import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    // constructor
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // getters
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class AvgSalaryByDepartment {
    public static void main(String[] args) {

        // list of employees
        List<Employee> employees = List.of(
                new Employee("Arjun", "IT", 60000),
                new Employee("Meera", "IT", 70000),
                new Employee("Kiran", "HR", 50000),
                new Employee("Pooja", "HR", 55000),
                new Employee("Rohit", "Finance", 80000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        avgSalaryByDept.forEach((dept, avgSalary) ->
                System.out.println(dept + " - Average Salary: " + avgSalary)
        );
    }
}
