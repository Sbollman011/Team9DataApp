package com.example;

public class Employee {

    double salary;
    String employeeID,firstName, lastName, streetAddress, city, 
    state,zip, employeeStoreID;

    public Employee(String employeeID, String firstName, String lastName,
        double salary, String streetAddress, String city, String state, 
        String zip, String employeeStoreID) {

        this.employeeID= employeeID;
        this.firstName = firstName;
        this.lastName= lastName;
        this.salary = salary;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.employeeStoreID = employeeStoreID;
    }

    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    



}