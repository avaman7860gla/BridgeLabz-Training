package app;

import util.DatabaseUtil;
import java.sql.*;

public class ClinicApplication {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DatabaseUtil.getConnection();
            
            // Start transaction
            con.setAutoCommit(false); 

            // Insert patient
            String insertPatient = "INSERT INTO patients (name, dob, phone, email, address, blood_group) " 
            						+ "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement psPatient =con.prepareStatement(insertPatient, Statement.RETURN_GENERATED_KEYS);
            psPatient.setString(1, "Aman Verma");
            psPatient.setDate(2, Date.valueOf("2005-01-11"));
            psPatient.setString(3, "7777665554");
            psPatient.setString(4, "amanv@gmail.com");
            psPatient.setString(5, "Agra");
            psPatient.setString(6, "O+");
            psPatient.executeUpdate();

            ResultSet patientKeys = psPatient.getGeneratedKeys();
            patientKeys.next();
            int patientId = patientKeys.getInt(1);
            System.out.println("Patient inserted using PreparedStatement");

            // Fetch doctor id
            Statement stmt = con.createStatement();
            ResultSet drRs = stmt.executeQuery("SELECT doctor_id FROM doctors WHERE is_active = true LIMIT 1");

            if (!drRs.next()) {
                throw new RuntimeException("No active doctor found in database");
            }

            int doctorId = drRs.getInt("doctor_id");

            // Insert appointment
            String insertAppointment ="INSERT INTO appointments " +
                "(patient_id, doctor_id, appointment_date, appointment_time, status) " +
                "VALUES (?, ?, CURDATE(), '11:00:00', 'SCHEDULED')";

            PreparedStatement psAppointment = con.prepareStatement(insertAppointment, Statement.RETURN_GENERATED_KEYS);
            psAppointment.setInt(1, patientId);
            psAppointment.setInt(2, doctorId);
            psAppointment.executeUpdate();
            ResultSet appKeys = psAppointment.getGeneratedKeys();
            appKeys.next();
            int appointmentId = appKeys.getInt(1);

            // Insert visit
            String insertVisit ="INSERT INTO visits (appointment_id, diagnosis, notes, visit_date) " +
                "VALUES (?, ?, ?, CURDATE())";

            PreparedStatement psVisit =con.prepareStatement(insertVisit, Statement.RETURN_GENERATED_KEYS);
            psVisit.setInt(1, appointmentId);
            psVisit.setString(2, "General Checkup");
            psVisit.setString(3, "Patient stable");
            psVisit.executeUpdate();
            ResultSet visitKeys = psVisit.getGeneratedKeys();
            visitKeys.next();
            int visitId = visitKeys.getInt(1);

            // Batch insert prescription
            String insertPrescription = "INSERT INTO prescriptions (visit_id, medicine_name, dosage, duration) " +
            							"VALUES (?, ?, ?, ?)";

            PreparedStatement psBatch =con.prepareStatement(insertPrescription);
            psBatch.setInt(1, visitId);
            psBatch.setString(2, "Paracetamol");
            psBatch.setString(3, "500mg");
            psBatch.setString(4, "5 days");
            psBatch.addBatch();
            
            psBatch.setInt(1, visitId);
            psBatch.setString(2, "Vitamin C");
            psBatch.setString(3, "Once daily");
            psBatch.setString(4, "7 days");
            psBatch.addBatch();
            psBatch.executeBatch();

            // Aggregate function
            String aggregateQuery = "SELECT COUNT(*) AS totalBills, " +
                "IFNULL(SUM(total_amount),0) AS revenue, " +
                "IFNULL(AVG(total_amount),0) AS avgBill " +
                "FROM bills";

            ResultSet aggRs =con.createStatement().executeQuery(aggregateQuery);
            if (aggRs.next()) {
                System.out.println("Total Bills: " + aggRs.getInt("totalBills"));
                System.out.println("Total Revenue: " + aggRs.getDouble("revenue"));
                System.out.println("Average Bill: " + aggRs.getDouble("avgBill"));
            }

            // Join query
            String joinQuery = "SELECT p.name AS patient, d.name AS doctor, a.appointment_date " +
                "FROM appointments a " +
                "JOIN patients p ON a.patient_id = p.patient_id " +
                "JOIN doctors d ON a.doctor_id = d.doctor_id";

            ResultSet rs = con.createStatement().executeQuery(joinQuery);
            System.out.println("Appointments:");
            while (rs.next()) {
                System.out.println(
                    rs.getString("patient") + " | " +
                    rs.getString("doctor") + " | " +
                    rs.getDate("appointment_date")
                );
            }

            // Result set meta data
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println("Columns:");
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println(meta.getColumnName(i));
            }
            con.commit();
            System.out.println("Transaction committed successfully");

        }
        catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction rolled back");
                }
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } 
        finally {
            try {
                if (con != null) con.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
