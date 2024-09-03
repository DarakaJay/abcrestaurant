package com.abcresttaurant.service;

import java.sql.SQLException;
import java.util.List;

import com.abcresttaurant.dao.QueryDAO;
import com.abcresttaurant.model.Query;

public class QueryService {
	
	 private static QueryService instance;
	    private QueryDAO queryDAO;

	    private QueryService() {
	        this.queryDAO = new QueryDAO();
	    }

	    public static QueryService getInstance() {
	        if (instance == null) {
	            synchronized (QueryService.class) {
	                if (instance == null) {
	                    instance = new QueryService();
	                }
	            }
	        }
	        return instance;
	    }

	    public void addQuery(Query query) {
	        queryDAO.addQuery(query);
	    }

	    public List<Query> getAllQueries() throws SQLException {
	        return queryDAO.getAllQueries();
	    }

}
