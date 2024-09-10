package com.abcresttaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcresttaurant.model.Availability;
import com.abcresttaurant.service.AvailabilityService;

@WebServlet("/rates")
public class AvailabilityController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AvailabilityService availabilityService;

    public void init() throws ServletException {
        availabilityService = AvailabilityService.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceType = request.getParameter("service");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        int numberOfGuests = Integer.parseInt(request.getParameter("guests"));

        Availability availability = new Availability();
        availability.setServiceType(serviceType);
        availability.setDate(date);
        availability.setTime(time);
        availability.setNumberOfGuests(numberOfGuests);

        boolean isAvailable = availabilityService.checkAvailability(availability);
        request.setAttribute("availability", isAvailable);
        request.getRequestDispatcher("/rates.js").forward(request, response);
    }
}
