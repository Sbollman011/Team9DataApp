package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


//QUERY STATEMENTS
import java.util.*;

@Component
public class Product_OrderedService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product_Ordered> findAll() {
        return jdbcTemplate.query("SELECT * FROM Product_Ordered",
                (rs, rowNum) -> new Product_Ordered(rs.getString("PO_OrderID"), rs.getString("PO_ProductID"), rs.getString("Quantity")));
    }

    public void update(Product_Ordered product_ordered) {
        jdbcTemplate.update("UPDATE Product_Ordered SET PO_OrderID =?, PO_ProductID=?,Quantity=? WHERE PO_OrderID=?",
        product_ordered.getPoOrderedID(),product_ordered.getproductOrderedProductID(), product_ordered.getproductOrderedQuantity(),product_ordered.getPoOrderedID());
    }

    /*public List<Category> insert(){
        return jdbcTemplate.query("INSERT INTO Category (CategoryName,SubCategoryName) VALUES (?,?) ",
        (rs,rowNum)-> new Category(rs.getString("CategoryName"),rs.getString("SubCategoryName")));
    }*/
}
