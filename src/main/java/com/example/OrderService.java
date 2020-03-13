package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;




    public List<Order> findAll() {
        return jdbcTemplate.query("SELECT * FROM `Order`",
                (rs, rowNum) -> new Order(rs.getString("OrderID"), rs.getString("OrderDate"),rs.getString("ShipDate"), rs.getString("Total"),rs.getString("OrderVendorID"),
                rs.getString("OrderStoreID")));
    }

    public void update(Order order) {
        jdbcTemplate.update("UPDATE Order SET OrderID=?, OrderDate=?, Salary=?, ShipDate=?, Total=?, OrderVendorID=?, OrderStoreID=?",
              order.getOrderID(), order.getOrderDate(), order.getOrderShipDate(),order.getOrderTotal(),order.getOrderVendorID(),
              order.getOrderStoreID());
    }

}