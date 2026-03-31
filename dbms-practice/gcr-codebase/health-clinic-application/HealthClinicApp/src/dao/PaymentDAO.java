package dao;

import util.DatabaseUtil;
import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class PaymentDAO {

    // Record payment
    public void recordPayment(Payment payment) throws Exception {

        String sql = "INSERT INTO payment_transactions (bill_id, payment_mode, payment_date) " +
            "VALUES (?, ?, ?)";
        Connection con = DatabaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, payment.getBillId());
        ps.setString(2, payment.getPaymentMode());
        ps.setDate(3, Date.valueOf(payment.getPaymentDate()));
        ps.executeUpdate();
        con.close();
    }
}
