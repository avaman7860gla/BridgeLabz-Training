package dao;

import util.DatabaseUtil;
import model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDAO {

    // Add doctor profile
    public void addDoctor(Doctor doctor) throws Exception {

        String sql = "INSERT INTO doctors (name, contact, consultation_fee, specialty_id, is_active) " +
            "VALUES (?, ?, ?, ?, true)";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, doctor.getName());
        ps.setString(2, doctor.getContact());
        ps.setDouble(3, doctor.getConsultationFee());
        ps.setInt(4, doctor.getSpecialtyId());
        ps.executeUpdate();
        con.close();
    }

    // View doctors by specialty
    public ResultSet getDoctorsBySpecialty(String specialtyName) throws Exception {

        String sql = "SELECT d.doctor_id, d.name, s.specialty_name " +
            "FROM doctors d JOIN specialties s " +
            "ON d.specialty_id = s.specialty_id " +
            "WHERE s.specialty_name = ? AND d.is_active = true";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, specialtyName);
        return ps.executeQuery();
    }

    // Deactivate doctor
    public void deactivateDoctor(int doctorId) throws Exception {

        String sql = "UPDATE doctors SET is_active = false WHERE doctor_id = ?";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, doctorId);
        ps.executeUpdate();
        con.close();
    }
}
