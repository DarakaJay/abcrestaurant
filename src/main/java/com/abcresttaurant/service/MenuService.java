package com.abcresttaurant.service;

import java.sql.SQLException;
import java.util.List;
import com.abcresttaurant.dao.MenuDAO;
import com.abcresttaurant.model.MenuItem;

public class MenuService {
	 private static MenuService instance;
	    private MenuDAO menuDAO;

	    private MenuService() {
	        this.menuDAO = new MenuDAO();
	    }

	    public static MenuService getInstance() {
	        if (instance == null) {
	            synchronized (MenuService.class) {
	                if (instance == null) {
	                    instance = new MenuService();
	                }
	            }
	        }
	        return instance;
	    }

	    public void addMenuItem(MenuItem menuItem) {
	        menuDAO.addMenuItem(menuItem);
	    }

	    public void updateMenuItem(MenuItem menuItem) {
	        menuDAO.updateMenuItem(menuItem);
	    }

	    public void deleteMenuItem(int menuItemId) {
	        menuDAO.deleteMenuItem(menuItemId);
	    }

	    public MenuItem getMenuItemById(int menuItemId) throws SQLException {
	        return menuDAO.getMenuItemById(menuItemId);
	    }

	    public List<MenuItem> getAllMenuItems() throws SQLException {
	        return menuDAO.getAllmenuitem();
	    }

}
