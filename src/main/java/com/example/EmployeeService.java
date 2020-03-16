package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;




    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                (rs, rowNum) -> new Employee(rs.getString("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"),rs.getString("Salary"),
                rs.getString("StreetAddress"),rs.getString("City"),rs.getString("State"),rs.getString("Zip"),rs.getString("EmployeeStoreID")));
    }

    public void update(String eFname, String eLname, String eSalary, String eAddress, String eCity, String eState, String eZip, String eStoreID, String eID) {
        jdbcTemplate.update("UPDATE Employee SET FirstName='"+eFname+"', LastName='"+eLname+
        "', Salary='"+eSalary+"', StreetAddress='"+eAddress+"', City='"+eCity+"', State='"+eState+"', Zip='"+eZip+
        "', EmployeeStoreID='"+eStoreID+"' WHERE EmployeeID='"+eZip+"'");
    
    }

}