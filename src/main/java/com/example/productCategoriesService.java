package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class productCategoriesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<productCategories> findAll() {
        return jdbcTemplate.query("SELECT * FROM product_categories",
                (rs, rowNum) -> new productCategories(rs.getString("ProductID"), rs.getString("CategoryName"), rs.getString("SubCategoryName")));
    }

    public void update(productCategories productcategories) {
        jdbcTemplate.update("UPDATE Product_Categories SET  CategoryName=?, SubCategoryName=? WHERE ProductID=?",
                productcategories.getProductCategoriesName(), productcategories.getProductCategoriesSubName(),
                productcategories.getProductCategoriesID());
    }

    /*public List<Category> insert(){
        return jdbcTemplate.query("INSERT INTO Category (CategoryName,SubCategoryName) VALUES (?,?) ",
        (rs,rowNum)-> new Category(rs.getString("CategoryName"),rs.getString("SubCategoryName")));
    }*/
}
