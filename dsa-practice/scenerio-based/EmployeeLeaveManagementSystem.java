import java.util.*;

// Custom exception
class InsufficientLeaveBalanceException extends Exception {
    InsufficientLeaveBalanceException(String msg) {
        super(msg);
    }
}

// Status constants
interface RequestStatusConst {
    String PENDING ="PENDING";
    String APPROVED="APPROVED";
    String REJECTED = "REJECTED";
}

class Employee {
    private String employeeId;
    private String name;
    private int leaveBalance;

    // Constructor
    public Employee(String employeeId, String name, int leaveBalance) {
        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    // Setter
    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", leaveBalance=" + leaveBalance +
                '}';
    }
}


class LeaveRequest {
    private String requestId;
    private String employeeId;
    private int daysRequested;
    private String status;

    // Constructor
    public LeaveRequest(String requestId, String employeeId, int daysRequested) {
        this.requestId = requestId;
        this.employeeId = employeeId;
        this.daysRequested = daysRequested;
        this.status = RequestStatusConst.PENDING;
    }

    // Getters
    public String getRequestId() {
        return requestId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getDaysRequested() {
        return daysRequested;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString method
    @Override
    public String toString() {
        return "LeaveRequest{" +
                "requestId='" + requestId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", daysRequested=" + daysRequested +
                ", status='" + status + '\'' +
                '}';
    }
}


class LeaveManagementSystem {
    private Map<String, Employee> employees = new HashMap<>();
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    // Method to add Employees
    public void addEmployee(Employee e) {
        if (employees.containsKey(e.getEmployeeId())) {
            System.out.println("Duplicate employee not allowed");
            return;
        }
        employees.put(e.getEmployeeId(), e);
        System.out.println("Employee added: " + e.getName());
    }

    // Method to apply leave
    public void applyLeave(String empId, int days) throws InsufficientLeaveBalanceException {
        Employee emp = employees.get(empId);
        if (emp == null) {
            System.out.println("Employee not found");
            return;
        }
        if (days > emp.getLeaveBalance()) {
            throw new InsufficientLeaveBalanceException("Insufficient leave balance");
        }
        String reqId = UUID.randomUUID().toString();
        LeaveRequest req = new LeaveRequest(reqId, empId, days);
        leaveRequests.add(req);
        System.out.println(empId + " applied leave for " + days + " days");
    }

    // Method to approve leave
    public void approveLeave(String reqId) {
        for (LeaveRequest req : leaveRequests) {
            if (req.getRequestId().equals(reqId) && req.getStatus().equals(RequestStatusConst.PENDING)) {
                Employee emp = employees.get(req.getEmployeeId());
                emp.setLeaveBalance(emp.getLeaveBalance() - req.getDaysRequested());
                req.setStatus(RequestStatusConst.APPROVED);
                System.out.println("Leave approved: " + reqId);
                return;
            }
        }
        System.out.println("Request not found or already processed");
    }

    // Method to reject Leave
    public void rejectLeave(String reqId) {
        for (LeaveRequest req : leaveRequests) {
            if (req.getRequestId().equals(reqId) && req.getStatus().equals(RequestStatusConst.PENDING)) {
                req.setStatus(RequestStatusConst.REJECTED);
                System.out.println("Leave rejected: " + reqId);
                return;
            }
        }
        System.out.println("Request not found or already processed");
    }

    // Method to get all requests
    public List<LeaveRequest> getAllRequests() {
        return leaveRequests;
    }
}


public class EmployeeLeaveManagementSystem {
    public static void main(String[] args) {
        LeaveManagementSystem system = new LeaveManagementSystem();
        Employee e1 = new Employee("E101", "Raj", 10);
        Employee e2 = new Employee("E102", "Rohan", 5);
        system.addEmployee(e1);
        system.addEmployee(e2);

        try {
            system.applyLeave("E101", 4);
            system.applyLeave("E102", 3); // will throw exception
        }
        catch (InsufficientLeaveBalanceException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        String firstRequestId = system.getAllRequests().get(0).getRequestId();
        system.approveLeave(firstRequestId);

        if (system.getAllRequests().size() > 1) {
            String secondRequestId = system.getAllRequests().get(1).getRequestId();
            system.rejectLeave(secondRequestId);
        }

        System.out.println("\nAll Leave Requests:");
        for (LeaveRequest req : system.getAllRequests()) {
            System.out.println(req.toString());
        }
        System.out.println("\nEmployees:");
        System.out.println(e1);
        System.out.println(e2);
    }
}
