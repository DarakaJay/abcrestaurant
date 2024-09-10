package com.abcresttaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abcresttaurant.model.Staff;
import com.abcresttaurant.service.StaffService;

@WebServlet("/staff")
public class StaffController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StaffService staffService;

    public void init() throws ServletException {
        staffService = StaffService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listStaff(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addStaff(request, response);
        }
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("staffList", staffService.getAllStaff());
            request.getRequestDispatcher("/staffreg.js").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/staffreg.js").forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/staffreg.js").forward(request, response);
    }

    private void addStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Staff staff = new Staff();
        staff.setName(name);
        staff.setRole(role);
        staff.setEmail(email);
        staff.setPassword(password);

        staffService.addStaff(staff);
        response.sendRedirect("staff?action=list");
    }
}