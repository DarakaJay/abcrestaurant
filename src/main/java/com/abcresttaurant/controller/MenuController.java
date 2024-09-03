package com.abcresttaurant.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcresttaurant.model.MenuItem;
import com.abcresttaurant.service.MenuService;

@WebServlet("/menu")
public class MenuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private MenuService menuService;

    public void init() throws ServletException {
        menuService = MenuService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listMenuItems(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        } else if (action.equals("edit")) {
            showEditForm(request, response);
        } else if (action.equals("delete")) {
            deleteMenuItem(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addMenuItem(request, response);
        } else if (action.equals("update")) {
            updateMenuItem(request, response);
        }
    }

    private void listMenuItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<MenuItem> menuItems = menuService.getAllMenuItems();
            request.setAttribute("menuItems", menuItems);
            request.getRequestDispatcher("WEB-INF/view/listMenuItems.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/addMenuItem.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            MenuItem existingMenuItem = menuService.getMenuItemById(id);
            request.setAttribute("menuItem", existingMenuItem);
            request.getRequestDispatcher("WEB-INF/view/editMenuItem.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void addMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setCategory(category);
        menuItem.setPrice(price);
        menuItem.setDescription(description);

        menuService.addMenuItem(menuItem);
        response.sendRedirect("menu?action=list");
    }

    private void updateMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        MenuItem menuItem = new MenuItem(id, name, category, price, description);
        menuService.updateMenuItem(menuItem);
        response.sendRedirect("menu?action=list");
    }

    private void deleteMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            menuService.deleteMenuItem(id);
            response.sendRedirect("menu?action=list");
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }
}