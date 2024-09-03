package com.abcresttaurant.model;

public class Reservation {
	
    private int reservationId;
    private String customerName;
    private String reservationDate;
    private int numberOfPeople;

    public Reservation(int reservationId, String customerName, String reservationDate, int numberOfPeople) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.reservationDate = reservationDate;
        this.numberOfPeople = numberOfPeople;
    }

    public Reservation() {
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

}
