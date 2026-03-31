import java.time.LocalDate;
import java.util.*;

// policy class
class Policy {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;

    // constructor
    Policy(String number, String name, LocalDate expiry) {
        this.policyNumber = number;
        this.holderName = name;
        this.expiryDate = expiry;
    }

    // convert to string
    public String toString() {
        return (policyNumber + " - " + holderName + " - " + expiryDate);
    }
}

public class InsurancePolicyManagement {
    public static void main(String[] args) {

        // hashmap, linked hashmap and tree map
        Map<String, Policy> hashMap = new HashMap<>();
        Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
        TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

        Policy p1 = new Policy("101", "Aman", LocalDate.now().plusDays(15));
        Policy p2 = new Policy("102", "Prince", LocalDate.now().plusDays(45));
        Policy p3 = new Policy("103", "Aman", LocalDate.now().minusDays(5));

        for (Policy p : List.of(p1, p2, p3)) {
            hashMap.put(p.policyNumber, p);
            linkedHashMap.put(p.policyNumber, p);
            treeMap.computeIfAbsent(p.expiryDate, k -> new ArrayList<>()).add(p);
        }

        // retrieve policy
        System.out.println("Retrieve by Number (101): " + hashMap.get("101"));

        // next expiring policies
        System.out.println("Policies expiring in next 30 days:");
        LocalDate now = LocalDate.now();
        LocalDate cutoff = now.plusDays(30);
        treeMap.subMap(now, true, cutoff, true).values().forEach(System.out::println);

        // display policies
        System.out.println("Policies for Aman:");
        for (Policy p : hashMap.values()) {
            if (p.holderName.equals("Aman")) {
                System.out.println(p);
            }
        }

        // removing expired policies
        System.out.println("Removing expired policies:");
        hashMap.values().removeIf(p -> p.expiryDate.isBefore(now));
        hashMap.values().forEach(System.out::println);
    }
}