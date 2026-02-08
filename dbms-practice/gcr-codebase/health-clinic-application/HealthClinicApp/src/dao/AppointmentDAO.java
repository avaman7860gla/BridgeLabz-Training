package dao;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;

public class AppointmentDAO {

    // Book appointment
    public void bookAppointment(int patientId, int doctorId, Date date, Time time)
            throws Exception {

        String sql ="INSERT INTO appointments (patient_id, doctor_id, appointment_date, appointment_time, status) " +
            "VALUES (?, ?, ?, ?, 'SCHEDULED')";

        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, patientId);
        ps.setInt(2, doctorId);
        ps.setDate(3, date);
        ps.setTime(4, time);
        ps.executeUpdate();
        con.close();
    }

    // View daily appointments
    public ResultSet getAppointmentsByDate(Date date) throws Exception {

        String sql = "SELECT a.appointment_time, p.name AS patient, d.name AS doctor, a.status " +
            "FROM appointments a " +
            "JOIN patients p ON a.patient_id = p.patient_id " +
            "JOIN doctors d ON a.doctor_id = d.doctor_id " +
            "WHERE a.appointment_date = ? " +
            "ORDER BY a.appointment_time";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, date);
        return ps.executeQuery();
    }

    // Cancel appointment
    public void cancelAppointment(int appointmentId) throws Exception {

        String sql = "UPDATE appointments SET status = 'CANCELLED' WHERE appointment_id = ?";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, appointmentId);
        ps.executeUpdate();
        con.close();
    }
}
