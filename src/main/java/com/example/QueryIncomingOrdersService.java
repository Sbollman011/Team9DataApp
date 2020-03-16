package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class QueryIncomingOrdersService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QueryIncomingOrders> findAll(String orderStoreID) {
        return jdbcTemplate.query("SELECT Name, OrderDate, ShipDate, Quantity FROM `Order`, `Product`, `Product_Ordered` " +
        "WHERE OrderID = PO_OrderID AND PO_ProductID = ProductID AND OrderStoreID ='"+orderStoreID+"'" ,
        
        (rs, rowNum) -> new QueryIncomingOrders(rs.getString("Name"),rs.getString("OrderDate"),rs.getString("ShipDate"),
        rs.getString("Quantity")));
    }
}