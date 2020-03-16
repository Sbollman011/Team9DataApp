package com.example;

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
                (rs, rowNum) -> new Customer(rs.getString("CustomerID"), rs.getString("FirstName"), rs.getString("LastName"),rs.getString("BillAddress"),
                rs.getString("BillCity"),rs.getString("BillState"),rs.getString("BillZip"),rs.getString("ShipAddress"),rs.getString("ShipCity"),rs.getString("ShipState"),rs.getString("ShipZip"),rs.getString("Phone"),rs.getString("Email")));
    }

    public void update(Customer customer) {
        jdbcTemplate.update("UPDATE Customer SET FirstName=?, LastName=?, BillAddress=?, BillCity=?, BillState=?, BillZip=?, ShipAddress=?, ShipCity=?, ShipState=?, ShipZip=?, Phone=?, Email=? WHERE CustomerID=?",
               customer.getCustomerFirstName(), customer.getCustomerLastName(),customer.getBillAddress(),customer.getBillCity(),customer.getBillState(),customer.getBillZip(),
              customer.getShipAddress(),customer.getShipCity(),customer.getShipState(),customer.getShipZip(),customer.getPhone(),customer.getEmail(),customer.getCustomerID());
    }

}
