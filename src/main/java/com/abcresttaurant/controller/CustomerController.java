package com.abcresttaurant.controller;

import java.io.IOException;

import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abcresttaurant.model.Customer;
import com.abcresttaurant.service.CustomerService;

	@WebServlet("/customerreg")
	public class CustomerController extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    private CustomerService customerService;

	    public void init() throws ServletException {
	        customerService = CustomerService.getInstance();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("/customerreg.js").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        Customer customer = new Customer();
	        customer.setName(name);
	        customer.setEmail(email);
	        customer.setPassword(password);

	        try {
	            if (customerService.getCustomerByEmail(email) == null) {
	                customerService.addCustomer(customer);
	                response.sendRedirect("home.js");
	            } else {
	                request.setAttribute("errorMessage", "Email already registered.");
	                request.getRequestDispatcher("/customerreg.js").forward(request, response);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Registration failed. Please try again.");
	            request.getRequestDispatcher("/customerreg.js").forward(request, response);
	        }
	    }
	}

	
	
	

