package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate;




    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM Product ",
                (rs, rowNum) -> new Product(rs.getString("ProductID"), rs.getString("Name"),rs.getString("Description"),
                 rs.getString("Price")));
    }

    public void update(Product product) {
        jdbcTemplate.update("UPDATE Product SET ProductID=?, Name=?, Description=?, Price=?, WHERE ProductID=?" ,
              product.getProductID(), product.getProductName(), product.getProductDescription(),product.getProductPrice());

    }   
}