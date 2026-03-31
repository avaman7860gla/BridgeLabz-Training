package dao;

import util.DatabaseUtil;
import model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillDAO {

    // Generate bill
    public void generateBill(Bill bill) throws Exception {

        String sql = "INSERT INTO bills (visit_id, total_amount, payment_status) " +
            "VALUES (?, ?, 'UNPAID')";

        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bill.getVisitId());
        ps.setDouble(2, bill.getTotalAmount());
        ps.executeUpdate();
        con.close();
    }
}
