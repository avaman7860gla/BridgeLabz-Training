import java.util.*;

// Custom exception
class SlotUnavailableException extends Exception{
    SlotUnavailableException(String mssg){
        super(mssg);
    }
}

class Doctor{
    private int doctorId;
    private String name;
    private String specialization;
    private List<String> availableSlot;

    // Constructor
    public Doctor(int doctorId, String name, String specialization, List<String> availableSlot){
        this.doctorId=doctorId;
        this.name=name;
        this.specialization=specialization;
        this.availableSlot=availableSlot;
    }

    // Getters
    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<String> getAvailableSlot() {
        return availableSlot;
    }

    // Method to book slot
    public void bookSlot(String slot) throws SlotUnavailableException{
        if(!availableSlot.contains(slot)){
            throw new SlotUnavailableException("Slot not available");
        }
        availableSlot.remove(slot);
    }
}

class Patient{
    private int patientId;
    private String name;
    private List<Appointment> history=new ArrayList<>();

    // Constructor
    public Patient(int patientId, String name){
        this.patientId=patientId;
        this.name=name;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getHistory() {
        return history;
    }

    // Method to add appointment 
    public void addAppointment(Appointment app){
        history.add(app);
    }
}

class Appointment{
    private Doctor doctor;
    private Patient patient;
    private String slot;

    // Constructor
    public Appointment(Doctor doctor, Patient patient, String slot) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    // Getters
    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getSlot() {
        return slot;
    }
}

class ConsultationScheduler{
    private Map<String, List<Doctor>> doctors=new HashMap<>();

    // Method to add doctor
    public void addDoctor(Doctor doc){
        if(!doctors.containsKey(doc.getSpecialization())){
            doctors.put(doc.getSpecialization(), new ArrayList<>());
        }
        doctors.get(doc.getSpecialization()).add(doc);
    }

    // Method to book appointment
    public Appointment bookAppointment(Patient patient, String specialization, String slot)
            throws SlotUnavailableException{
        List<Doctor> availableDoctors=doctors.getOrDefault(specialization, new ArrayList<>());
        for(Doctor d:availableDoctors){
            try{
                d.bookSlot(slot);
                Appointment app=new Appointment(d, patient, slot);
                patient.addAppointment(app);
                return app;
            }
            catch (SlotUnavailableException e){
                System.out.println();
            }
        }
        throw new SlotUnavailableException("No slot available for specialization "+specialization);
    }

    // Method to get doctors by speciality
    public List<Doctor> getDoctorsBySpecialization(String spec){
        return doctors.getOrDefault(spec, new ArrayList<>());
    }
}

public class OnlineDoctorConsultationScheduler {
    public static void main(String[] args) {
        ConsultationScheduler scheduler = new ConsultationScheduler();

        Doctor d1 = new Doctor(1, "Dr. Sharma", "Cardiology", new ArrayList<>(Arrays.asList("10AM", "11AM")));
        Doctor d2 = new Doctor(2, "Dr. Mehta", "Cardiology", new ArrayList<>(Arrays.asList("11AM", "12PM")));
        Doctor d3 = new Doctor(3, "Dr. Gupta", "Dermatology", new ArrayList<>(Arrays.asList("2PM", "3PM")));

        scheduler.addDoctor(d1);
        scheduler.addDoctor(d2);
        scheduler.addDoctor(d3);

        Patient p1 = new Patient(101, "Aman");
        Patient p2 = new Patient(102, "Riya");

        try {
            Appointment app1 = scheduler.bookAppointment(p1, "Cardiology", "11AM");
            System.out.println("Appointment booked: "+p1.getName()+" with "+
                    app1.getDoctor().getName()+" at "+app1.getSlot());
        }
        catch (SlotUnavailableException e) {
            System.out.println("Booking failed for Aman: " + e.getMessage());
        }

        try {
            Appointment app2 = scheduler.bookAppointment(p2, "Cardiology", "11AM");
            System.out.println("Appointment booked: " + p2.getName() + " with " +
                    app2.getDoctor().getName() + " at " + app2.getSlot());
        } 
        catch (SlotUnavailableException e) {
            System.out.println("Booking failed for Riya: " + e.getMessage());
        }

        try {
            Appointment app3 = scheduler.bookAppointment(p2, "Dermatology", "2PM");
            System.out.println("Appointment booked: " + p2.getName() + " with " +
                    app3.getDoctor().getName() + " at " + app3.getSlot());
        } 
        catch (SlotUnavailableException e) {
            System.out.println("Booking failed for Riya: " + e.getMessage());
        }

        System.out.println("\nConsultation history for " + p1.getName() + ":");
        for (Appointment a : p1.getHistory()) {
            System.out.println(a.getDoctor().getName() + " (" + a.getDoctor().getSpecialization() + ") at " + a.getSlot());
        }

        System.out.println("\nConsultation history for " + p2.getName() + ":");
        for (Appointment a : p2.getHistory()) {
            System.out.println(a.getDoctor().getName() + " (" + a.getDoctor().getSpecialization() + ") at " + a.getSlot());
        }
    }
}

