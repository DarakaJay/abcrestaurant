package com.abcresttaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcresttaurant.model.Staff;

public class StaffDAO {

    public void addStaff(Staff staff) {
        String query = "INSERT INTO staff (name, role, email, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getRole());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Staff> getAllStaff() throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        String query = "SELECT * FROM staff";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("staffId");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                staffList.add(new Staff(id, name, role, email, password));
            }
        }
        return staffList;
    }
}
