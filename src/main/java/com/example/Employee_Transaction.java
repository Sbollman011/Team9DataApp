package com.example;

public class Employee_Transaction {

    
    String employeeID,transactionID;

    public Employee_Transaction(String employeeID, String transactionID) {
        this.employeeID= employeeID;
        this.transactionID = transactionID;

    }

    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

}