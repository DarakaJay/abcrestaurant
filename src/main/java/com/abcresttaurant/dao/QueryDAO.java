package com.abcresttaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcresttaurant.model.Query;

public class QueryDAO {

	
	public void addQuery(Query query) {
        String querySQL = "INSERT INTO query (customerName, queryContent, queryDate) VALUES (?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySQL)) {
            statement.setString(1, query.getCustomerName());
            statement.setString(2, query.getQueryContent());
            statement.setString(3, query.getQueryDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Query> getAllQueries() throws SQLException {
        List<Query> queries = new ArrayList<>();
        String querySQL = "SELECT * FROM query";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(querySQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int queryId = resultSet.getInt("queryId");
                String customerName = resultSet.getString("customerName");
                String queryContent = resultSet.getString("queryContent");
                String queryDate = resultSet.getString("queryDate");
                queries.add(new Query(queryId, customerName, queryContent, queryDate));
            }
        }
        return queries;
    }
}
