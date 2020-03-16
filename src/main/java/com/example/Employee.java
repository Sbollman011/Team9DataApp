package com.example;

public class Employee {

 
    String employeeID,employeeFirstName, employeeLastName, salary, employeeStreetAddress, employeeCity, 
    employeeState,employeeZip, employeeStoreID;

    public Employee(String employeeID, String employeeFirstName, String employeeLastName,String salary
        , String employeeStreetAddress, String employeeCity, String employeeState, 
        String employeeZip, String employeeStoreID) {

        this.employeeID= employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName= employeeLastName;
        this.salary = salary;
        this.employeeStreetAddress = employeeStreetAddress;
        this.employeeCity = employeeCity;
        this.employeeState = employeeState;
        this.employeeZip = employeeZip;
        this.employeeStoreID = employeeStoreID;
    }

    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmployeeStreetAddress() {
        return employeeStreetAddress;
    }

    public void setStreetAddress(String employeeStreetAddress) {
        this.employeeStreetAddress =employeeStreetAddress;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setCity(String employeeCity) {
        this.employeeCity =employeeCity;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setState(String employeeState) {
        this.employeeState = employeeState;
    }

    public String getEmployeeZip() {
        return employeeZip;
    }

    public void setEmployeeZip(String employeeZip) {
        this.employeeZip = employeeZip;
    }

    public String getEmployeeStoreID(){
        return employeeStoreID;
    }

    public void setEmployeeStoreID(String employeeStoreID){
        this.employeeStoreID = employeeStoreID;
    }



    



}