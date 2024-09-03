package com.abcresttaurant.model;

public class Availability {

	
	private String serviceType;
    private String date;
    private String time;
    private int numberOfGuests;
    private boolean isAvailable;

    public Availability(String serviceType, String date, String time, int numberOfGuests, boolean isAvailable) {
        this.serviceType = serviceType;
        this.date = date;
        this.time = time;
        this.numberOfGuests = numberOfGuests;
        this.isAvailable = isAvailable;
    }

    public Availability() {
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
