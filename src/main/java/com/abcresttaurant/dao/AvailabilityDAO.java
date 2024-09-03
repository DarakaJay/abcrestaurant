package com.abcresttaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcresttaurant.model.Availability;

public class AvailabilityDAO {

	
	 public boolean checkAvailability(Availability availability) {
	        String query = "SELECT COUNT(*) FROM availability WHERE serviceType = ? AND date = ? AND time = ? AND numberOfGuests >= ?";
	        try (Connection connection = DBConnectionFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, availability.getServiceType());
	            statement.setString(2, availability.getDate());
	            statement.setString(3, availability.getTime());
	            statement.setInt(4, availability.getNumberOfGuests());
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count == 0;  // Return true if no reservations found for the given criteria
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}
