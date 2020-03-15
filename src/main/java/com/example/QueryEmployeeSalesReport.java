package com.example;



public class QueryEmployeeSalesReport {

    //getters and setters for the query to generate a sales report for a specific store
    String employeeNo, noOfSales;

    public QueryEmployeeSalesReport(String employeeNo, String noOfSales) {
        this.employeeNo= employeeNo;
        this.noOfSales = noOfSales;
        
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getNoOfSales() {
        return noOfSales;
    }

    public void setNoOfSales(String noOfSales) {
        this.noOfSales = noOfSales;
    }
}
   