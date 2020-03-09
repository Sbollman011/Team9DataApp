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
                (rs, rowNum) -> new Employee(rs.getString("EmployeeID"), rs.getString("FirstName"), rs.getString("LastName"),rs.getLong("Salary"),
                rs.getString("StreetAddress"),rs.getString("City"),rs.getString("State"),rs.getString("Zip"),rs.getString("EmployeeStoreID")));
    }

    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE Employee SET FirstName=?, LastName=?, Salary=?, StreetAddress=?, City=?, State=?, Zip=?, EmployeeStoreID=?, WHERE EmployeeID=?",
              employee.getEmployeeID(), employee.getEmployeeFirstName(), employee.getEmployeeLastName(),employee.getEmployeeStreetAddress(),employee.getEmployeeCity(),
              employee.getEmployeeState(),employee.getEmployeeZip(),employee.getEmployeeStoreID());
    }

}