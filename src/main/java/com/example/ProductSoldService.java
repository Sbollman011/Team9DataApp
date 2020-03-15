/*package com.example;

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
                (rs, rowNum) -> new ProductSold(rs.getString("soldTransactionID"), rs.getString("SOLD_ProductID"), rs.getString("soldQuantity")));
    }

    public void update(ProductSold productSold) {
        jdbcTemplate.update("UPDATE Product_Ordered SET PO_OrderID, PO_ProductID,Quantity WHERE PO_OrderID=?",
                productSold.getSoldTransactionID(), productSold.getSoldProductID(), productSold.getSoldQuantity());
    }

    /*public List<Category> insert(){
        return jdbcTemplate.query("INSERT INTO Category (CategoryName,SubCategoryName) VALUES (?,?) ",
        (rs,rowNum)-> new Category(rs.getString("CategoryName"),rs.getString("SubCategoryName")));
    }*/
//}