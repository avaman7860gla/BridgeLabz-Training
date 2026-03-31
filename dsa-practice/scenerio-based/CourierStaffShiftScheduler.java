import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee{
    private int id;
    private String name;
    private String role;

    // Constructor
    public Employee(int id, String name, String role){
        this.id=id;
        this.name=name;
        this.role=role;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

class ShiftTime{
    private LocalTime start;
    private LocalTime end;

    // Constructor
    public ShiftTime(LocalTime start, LocalTime end){
        this.start=start;
        this.end=end;
    }

    // Getters
    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    // Override toString method
    @Override
    public String toString() {
        return "ShiftTime{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

// Custom Exception
class ShiftAlreadyAssignedException extends Exception{
    ShiftAlreadyAssignedException(String mssg){
        super(mssg);
    }
}

class ShiftScheduler{
    private List<Employee> employees=new ArrayList<>();
    private Map<ShiftTime, List<Employee>> shiftAssignments=new HashMap<>();

    // Method to add employees
    public void addEmployee(Employee e){
        employees.add(e);
    }

    // Method to assign shifts
    public void assignShift(ShiftTime s, Employee e) throws ShiftAlreadyAssignedException{
        if(!shiftAssignments.containsKey(s)){
            shiftAssignments.put(s, new ArrayList<>());
        }
        if (shiftAssignments.get(s).contains(e)) {
            throw new ShiftAlreadyAssignedException(e.getName()+" is already assigned to shift: "+s.toString());
        }
        shiftAssignments.get(s).add(e);
    }

    // Method to get all employees
    public List<Employee> getEmployees(){
        return employees;
    }

    // Method to get shift assignment
    public Map<ShiftTime, List<Employee>> getShiftAssignments(){
        return shiftAssignments;
    }

    // Method to print schedule assigned
    public void printSchedule() {
        if (shiftAssignments.isEmpty()) {
            System.out.println("No shifts scheduled");
            return;
        }
        System.out.println("\nCourier Staff Shift Schedule:");
        for (Map.Entry<ShiftTime, List<Employee>> e:shiftAssignments.entrySet()) {
            ShiftTime shift=e.getKey();
            List<Employee> employees=e.getValue();
            System.out.println("\nShift: " + shift);
            if(employees.isEmpty()){
                System.out.println("No employees assigned");
            }
            else{
                for(Employee emp : employees){
                    System.out.println(emp.getName() + " (ID: " + emp.getId() + ", Role: " + emp.getRole() + ")");
                }
            }
        }
    }
}

public class CourierStaffShiftScheduler {
    public static void main(String[] args) {
        ShiftScheduler s=new ShiftScheduler();

        Employee e1=new Employee(1, "Aman", "Courier");
        Employee e2=new Employee(2, "Rahul", "Courier");
        Employee e3=new Employee(3, "Rohan", "Courier");

        s.addEmployee(e1);
        s.addEmployee(e2);
        s.addEmployee(e3);

        ShiftTime morning=new ShiftTime(LocalTime.of(9, 0), LocalTime.of(13, 0));
        ShiftTime afternoon=new ShiftTime(LocalTime.of(14, 0), LocalTime.of(18, 0));

        try{
            s.assignShift(morning, e1);
            s.assignShift(morning, e2);
            s.assignShift(afternoon, e3);

            s.assignShift(morning, e1);
        }
        catch (ShiftAlreadyAssignedException e) {
            System.out.println(e.getMessage());
        }

        s.printSchedule();
    }
}
