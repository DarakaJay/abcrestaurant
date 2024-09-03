package com.abcresttaurant.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcresttaurant.model.Customer;



public class CustomerDAO {
	
    public void addCustomer(Customer customer) {
        String query = "INSERT INTO customer_registration (name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerByEmail(String email) throws SQLException {
        String query = "SELECT * FROM customer_registration WHERE email = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    return new Customer(id, name, email, password);
                }
            }
        }
        return null;
    }

}
