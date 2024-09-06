package com.abcresttaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcresttaurant.model.Reservation;

public class ReservationDAO {
	
	 public void addReservation(Reservation reservation) {
	        String query = "INSERT INTO reservation (customerName, reservationDate, numberOfPeople) VALUES (?, ?, ?)";
	        try (Connection connection = DBConnectionFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, reservation.getCustomerName());
	            statement.setString(2, reservation.getReservationDate());
	            statement.setInt(3, reservation.getNumberOfPeople());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Reservation> getAllReservations() throws SQLException {
	        List<Reservation> reservations = new ArrayList<>();
	        String query = "SELECT * FROM reservation";
	        try (Connection connection = DBConnectionFactory.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int id = resultSet.getInt("reservationId");
	                String customerName = resultSet.getString("customerName");
	                String reservationDate = resultSet.getString("reservationDate");
	                int numberOfPeople = resultSet.getInt("numberOfPeople");
	                reservations.add(new Reservation(id, customerName, reservationDate, numberOfPeople));
	            }
	        }
	        return reservations;
	    }

}
