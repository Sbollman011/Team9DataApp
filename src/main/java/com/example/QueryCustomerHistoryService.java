package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class QueryCustomerHistoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QueryCustomerHistory> findAll(String customerID) {
        return jdbcTemplate.query("SELECT FirstName, LastName, TransactionID, Name, price " +
        "FROM Customer, Transaction, product, product_sold " +
        "WHERE TRANS_CustomerID = CustomerID AND SOLD_TransactionID = TransactionID AND SOLD_ProductID = ProductID AND CustomerID = "+customerID,
        
        (rs, rowNum) -> new QueryCustomerHistory(rs.getString("FirstName"),rs.getString("LastName"),rs.getString("TransactionID"),
        rs.getString("Name"),rs.getString("price")));
    }
}