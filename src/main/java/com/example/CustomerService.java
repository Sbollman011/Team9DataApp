package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.sql.SQLException;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.lang.Nullable;




import java.util.*;

@Component
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Customer",
                (rs, rowNum) -> new Customer(rs.getString("CustomerID"), rs.getString("FirstName"), rs.getString("LastName"),rs.getString("BillAddress"),
                rs.getString("BillCity"),rs.getString("BillState"),rs.getString("BillZip"),rs.getString("ShipAddress"),rs.getString("ShipCity"),rs.getString("ShipState"),rs.getString("ShipZip"),rs.getString("Phone"),rs.getString("Email")));
    }

    /*public void update(Customer customer) {
        jdbcTemplate.update("UPDATE Customer SET CustomerID=?, First_Name=?, Last_Name, Ship_Address,Ship_City,Ship_State,Ship_Zip,Bill_Address,Bill_city,Bill_State,Bill_Zip,Phone,Email  WHERE CustomerID=?",
              customer.getSubCategoryName(), customer.getDescription(), customer.getCategoryName());
    }*/

}
