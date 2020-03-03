/*package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM Customer",
                (rs, rowNum) -> new Customer(rs.getString("CustomerID"), rs.getString("First_Name"), rs.getString("Last_Name"),rs.getString("Ship_Address"),
                rs.getString("Ship_City"),rs.getString("Ship_State"),rs.getString("Ship_Zip"),rs.getString("Bill_Address"),rs.getString("Bill_City"),rs.getString("Bill_State"),rs.getString("Bill_Zip"),rs.getString("Phone"),rs.getString("Email")));
    }

    public void update(Customer customer) {
       /* jdbcTemplate.update("UPDATE Customer SET CustomerID=?, First_Name=?, Last_Name, Ship_Address,Ship_City,Ship_State,Ship_Zip,Bill_Address,Bill_city,Bill_State,Bill_Zip,Phone,Email  WHERE CustomerID=?",
              customer.getSubCategoryName(), customer.getDescription(), customer.getCategoryName());
    */ //}

//}
//*/