package com.abcresttaurant.service;

import java.sql.SQLException;

import java.util.List;

import com.abcresttaurant.dao.StaffDAO;
import com.abcresttaurant.model.Staff;

public class StaffService {
	
    private static StaffService instance;
    private StaffDAO staffDAO;

    private StaffService() {
        this.staffDAO = new StaffDAO();
    }

    public static StaffService getInstance() {
        if (instance == null) {
            synchronized (StaffService.class) {
                if (instance == null) {
                    instance = new StaffService();
                }
            }
        }
        return instance;
    }

    public void addStaff(Staff staff) {
        staffDAO.addStaff(staff);
    }

    public List<Staff> getAllStaff() throws SQLException {
        return staffDAO.getAllStaff();
    }

}
