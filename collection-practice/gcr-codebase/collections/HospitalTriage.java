import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    // constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // compareTo method
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    // toString method for display
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {

        // priority queue
        PriorityQueue<Patient> pq = new PriorityQueue<>();
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        // display
        while (!pq.isEmpty()) {
            System.out.println("Treating: " + pq.poll());
        }
    }
}
