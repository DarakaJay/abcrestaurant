package com.abcresttaurant.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcresttaurant.model.Query;
import com.abcresttaurant.service.QueryService;

@WebServlet("/query")
public class QueryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private QueryService queryService;

    public void init() throws ServletException {
        queryService = QueryService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("list")) {
            listQueries(request, response);
        } else if (action.equals("add")) {
            showAddForm(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            addQuery(request, response);
        }
    }

    private void listQueries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Query> queryList = queryService.getAllQueries();
            request.setAttribute("queries", queryList);
            request.getRequestDispatcher("WEB-INF/view/listQueries.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("WEB-INF/view/error.jsp").forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/addQuery.jsp").forward(request, response);
    }

    private void addQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String queryContent = request.getParameter("queryContent");
        String queryDate = request.getParameter("queryDate");

        Query query = new Query();
        query.setCustomerName(customerName);
        query.setQueryContent(queryContent);
        query.setQueryDate(queryDate);

        queryService.addQuery(query);
        response.sendRedirect("query?action=list");
    }
}
