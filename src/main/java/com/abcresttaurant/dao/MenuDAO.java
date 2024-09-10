package com.abcresttaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.abcresttaurant.model.MenuItem;

public class MenuDAO {
    public void addMenuItem(MenuItem menuItem) {
        String query = "INSERT INTO menuitem (name, category, price, description) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, menuItem.getName());
            statement.setString(2, menuItem.getCategory());
            statement.setDouble(3, menuItem.getPrice());
            statement.setString(4, menuItem.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMenuItem(MenuItem menuItem) {
        String query = "UPDATE menuitem SET name = ?, category = ?, price = ?, description = ? WHERE menuItemId = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, menuItem.getName());
            statement.setString(2, menuItem.getCategory());
            statement.setDouble(3, menuItem.getPrice());
            statement.setString(4, menuItem.getDescription());
            statement.setInt(5, menuItem.getMenuItemId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMenuItem(int menuItemId) {
        String query = "DELETE FROM menuitem WHERE menuItemId = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, menuItemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MenuItem getMenuItemById(int menuItemId) throws SQLException {
        MenuItem menuItem = null;
        String query = "SELECT * FROM menuitem WHERE menuItemId = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, menuItemId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String category = resultSet.getString("category");
                    double price = resultSet.getDouble("price");
                    String description = resultSet.getString("description");
                    menuItem = new MenuItem(menuItemId, name, category, price, description);
                }
            }
        }
        return menuItem;
    }

    public List<MenuItem> getAllmenuitem() throws SQLException {
        List<MenuItem> menuItems = new ArrayList<>();
        String query = "SELECT * FROM MenuItems";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("menuItemId");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                menuItems.add(new MenuItem(id, name, category, price, description));
            }
        }
        return menuItems;
    }
}
