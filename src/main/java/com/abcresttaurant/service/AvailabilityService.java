package com.abcresttaurant.service;

import com.abcresttaurant.dao.AvailabilityDAO;
import com.abcresttaurant.model.Availability;

public class AvailabilityService {
	
	 private static AvailabilityService instance;
	    private AvailabilityDAO availabilityDAO;

	    private AvailabilityService() {
	        this.availabilityDAO = new AvailabilityDAO();
	    }

	    public static AvailabilityService getInstance() {
	        if (instance == null) {
	            synchronized (AvailabilityService.class) {
	                if (instance == null) {
	                    instance = new AvailabilityService();
	                }
	            }
	        }
	        return instance;
	    }

	    public boolean checkAvailability(Availability availability) {
	        return availabilityDAO.checkAvailability(availability);
	    }

}
