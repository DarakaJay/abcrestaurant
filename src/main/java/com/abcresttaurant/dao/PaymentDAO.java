package com.abcresttaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcresttaurant.model.Payment;

public class PaymentDAO {

	public void addPayment(Payment payment) {
        String query = "INSERT INTO payment (reservationId, amount, paymentDate, paymentMethod) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, payment.getReservationId());
            statement.setDouble(2, payment.getAmount());
            statement.setString(3, payment.getPaymentDate());
            statement.setString(4, payment.getPaymentMethod());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payment";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("paymentId");
                int reservationId = resultSet.getInt("reservationId");
                double amount = resultSet.getDouble("amount");
                String paymentDate = resultSet.getString("paymentDate");
                String paymentMethod = resultSet.getString("paymentMethod");
                payments.add(new Payment(paymentId, reservationId, amount, paymentDate, paymentMethod));
            }
        }
        return payments;
    }

    public Payment getPaymentByReservationId(int reservationId) throws SQLException {
        String query = "SELECT * FROM payment WHERE reservationId = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservationId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int paymentId = resultSet.getInt("paymentId");
                double amount = resultSet.getDouble("amount");
                String paymentDate = resultSet.getString("paymentDate");
                String paymentMethod = resultSet.getString("paymentMethod");
                return new Payment(paymentId, reservationId, amount, paymentDate, paymentMethod);
            }
        }
        return null;
    }
}
