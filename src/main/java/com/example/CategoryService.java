package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//QUERY STATEMENTS

import java.util.*;

@Component
public class CategoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT CategoryName, SubCategoryName FROM Category",
                (rs, rowNum) -> new Category(rs.getString("CategoryName"), rs.getString("SubCategoryName")));
    }

    public void update(String cName, String cSubName) {
        jdbcTemplate.update("UPDATE Category SET CategoryName='"+cName+"', SubCategoryName='"+cSubName+"' WHERE CategoryName='"+cName+"'");
                
    }

    public int insert(String cName, String cSubName){
        return jdbcTemplate.update("INSERT INTO Category VALUES ('"+cName+"','"+cSubName+"')");
       // (rs,rowNum)-> new Category(rs.getString("CategoryName"),rs.getString("SubCategoryName")));
    }
}
