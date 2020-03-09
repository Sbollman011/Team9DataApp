package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class CategoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT CategoryName, SubCategoryName FROM Category",
                (rs, rowNum) -> new Category(rs.getString("CategoryName"), rs.getString("SubCategoryName")));
    }

    public void update(Category category) {
        jdbcTemplate.update("UPDATE Category SET SubCategoryName=? WHERE CategoryName=?",
                category.getCategoryName(),category.getSubCategoryName());
    }

    public List<Category> insert(){
        return jdbcTemplate.query("INSERT INTO Category (CategoryName,SubCategoryName) VALUES (?,?) ",
        (rs,rowNum)-> new Category(rs.getString("CategoryName"),rs.getString("SubCategoryName")));
    }
}
