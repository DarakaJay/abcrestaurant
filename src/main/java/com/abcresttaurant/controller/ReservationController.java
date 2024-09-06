package com.abcresttaurant.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcresttaurant.model.Reservation;
import com.abcresttaurant.service.ReservationService;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReservationService reservationService;

    public void init() throws ServletException {
        reservationService = ReservationService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listReservations(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addReservation(request, response);
        }
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Reservation> reservationList = reservationService.getAllReservations();
            request.setAttribute("reservations", reservationList);
            request.getRequestDispatcher("WEB-INF/view/listReservations.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/addReservation.jsp").forward(request, response);
    }

    private void addReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String reservationDate = request.getParameter("reservationDate");
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        
        Reservation reservation = new Reservation();
        reservation.setCustomerName(customerName);
        reservation.setReservationDate(reservationDate);
        reservation.setNumberOfPeople(numberOfPeople);
        
        reservationService.addReservation(reservation);
        response.sendRedirect("reservation?action=list");
    }
}

