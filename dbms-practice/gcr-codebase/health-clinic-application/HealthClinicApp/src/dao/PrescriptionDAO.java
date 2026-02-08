package dao;

import util.DatabaseUtil;
import model.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrescriptionDAO {

    // Add prescription
    public void addPrescription(Prescription prescription) throws Exception {
        String sql = "INSERT INTO prescriptions (visit_id, medicine_name, dosage, duration) " +
            "VALUES (?, ?, ?, ?)";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, prescription.getVisitId());
        ps.setString(2, prescription.getMedicineName());
        ps.setString(3, prescription.getDosage());
        ps.setString(4, prescription.getDuration());
        ps.executeUpdate();
        con.close();
    }
}
