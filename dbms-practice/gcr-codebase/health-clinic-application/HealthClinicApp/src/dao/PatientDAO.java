package dao;

import model.Patient;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class PatientDAO {

    // Register new patient
    public void addPatient(Patient patient) throws Exception {

        String sql ="INSERT INTO patients (name, dob, phone, email, address, blood_group) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, patient.getName());
        ps.setDate(2, Date.valueOf(patient.getDob()));
        ps.setString(3, patient.getPhone());
        ps.setString(4, patient.getEmail());
        ps.setString(5, patient.getAddress());
        ps.setString(6, patient.getBloodGroup());
        ps.executeUpdate();
        con.close();
    }

    // Search patient by phone
    public ResultSet findPatientByPhone(String phone) throws Exception {
        String sql = "SELECT * FROM patients WHERE phone = ?";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, phone);
        return ps.executeQuery();
    }
}
