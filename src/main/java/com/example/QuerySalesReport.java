package com.example;

import org.springframework.stereotype.Component;


public class QuerySalesReport {

    //getters and setters for the query to generate a sales report for a specific store
    String salesTransactionID, salesOrderDate, salesShipDate, salesTotal, salesCustomerID,salesEmployeeID, salesStoreID;

    public QuerySalesReport(String salesTransactionID,String salesOrderDate, String salesShipDate, String salesTotal,String salesCustomerID,
    String salesEmployeeID,String salesStoreID) {
        this.salesTransactionID= salesTransactionID;
        this.salesOrderDate = salesOrderDate;
        this.salesShipDate = salesShipDate;
        this.salesTotal = salesTotal;
        this.salesCustomerID = salesCustomerID;
        this.salesEmployeeID = salesEmployeeID;
        this.salesStoreID = salesStoreID;

    }

    public String getSalesTransactionID() {
        return salesTransactionID;
    }

    public void setTransStoreID(String salesTransactionID) {
        this.salesTransactionID = salesTransactionID;
    }

    public String getSalesOrderDate() {
        return salesOrderDate;
    }

    public void setSalesrderDate(String salesOrderDate) {
        this.salesOrderDate = salesOrderDate;
    }

    public String getSalesShipDate() {
        return salesShipDate;
    }

    public void setSalesShipDate(String salesShipDate) {
        this.salesShipDate = salesShipDate;
    }

    public String getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(String salesTotal) {
        this.salesTotal = salesTotal;
    }

    public String getSalesCustomerID() {
        return salesCustomerID;
    }

    public void setSalesCustomerID(String salesCustomerID) {
        this.salesCustomerID = salesCustomerID;
    }

    public String getSalesEmployeeID() {
        return salesEmployeeID;
    }

    public void setSalesEmployeeID(String salesEmployeeID) {
        this.salesEmployeeID = salesEmployeeID;
    }

    public String getSalesStoreID() {
        return salesStoreID;
    }

    public void setSalesStoreID(String salesStoreID) {
        this.salesStoreID = salesStoreID;
    }

}