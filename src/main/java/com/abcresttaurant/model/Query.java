package com.abcresttaurant.model;

public class Query {

	
	private int queryId;
    private String customerName;
    private String queryContent;
    private String queryDate;

    public Query(int queryId, String customerName, String queryContent, String queryDate) {
        this.queryId = queryId;
        this.customerName = customerName;
        this.queryContent = queryContent;
        this.queryDate = queryDate;
    }

    public Query() {
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getQueryContent() {
        return queryContent;
    }

    public void setQueryContent(String queryContent) {
        this.queryContent = queryContent;
    }

    public String getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(String queryDate) {
        this.queryDate = queryDate;
    }
}
