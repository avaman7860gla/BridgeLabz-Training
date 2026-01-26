// HospitalPatientIDPrinting.java
// Demonstrates method reference instead of lambda

import java.util.*;

public class HospitalPatientIdPrinting {

    public static void main(String[] args) {

        // List of patient IDs
        List<Integer> patientIds = new ArrayList<>();

        patientIds.add(101);
        patientIds.add(102);
        patientIds.add(103);
        patientIds.add(104);
        patientIds.add(105);

        System.out.println("---- Hospital Patient IDs ----");

        // Using method reference to print each patient ID
        patientIds.forEach(System.out::println);
    }
}
