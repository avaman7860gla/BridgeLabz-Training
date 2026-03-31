package dao;

import util.DatabaseUtil;
import model.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class VisitDAO {

    // Record patient visit
    public void addVisit(Visit visit) throws Exception {

        String sql = "INSERT INTO visits (appointment_id, diagnosis, notes, visit_date) " +
            "VALUES (?, ?, ?, ?)";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, visit.getAppointmentId());
        ps.setString(2, visit.getDiagnosis());
        ps.setString(3, visit.getNotes());
        ps.setDate(4, Date.valueOf(visit.getVisitDate()));
        ps.executeUpdate();
        con.close();
    }
}
