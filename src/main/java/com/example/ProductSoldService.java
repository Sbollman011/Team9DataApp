package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class ProductSoldService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductSold> findAll() {
        return jdbcTemplate.query("SELECT * FROM product_sold",
                (rs, rowNum) -> new ProductSold(rs.getString("SOLD_TransactionID"), rs.getString("SOLD_ProductID"), rs.getString("Quantity")));
    }

    public void update(ProductSold productSold) {
        jdbcTemplate.update("UPDATE product_sold SET SOLD_ProductID=?,Quantity=? WHERE SOLD_TransactionID=?",
       productSold.getSoldProductID(), productSold.getSoldQuantity(),productSold.getSoldTransactionID());
    }

    /*public List<Category> insert(){
        return jdbcTemplate.query("INSERT INTO Category (CategoryName,SubCategoryName) VALUES (?,?) ",
        (rs,rowNum)-> new Category(rs.getString("CategoryName"),rs.getString("SubCategoryName")));
    }*/
}