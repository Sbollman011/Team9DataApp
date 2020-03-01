package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT categoryName, subCategoryName, description FROM Category",
                (rs, rowNum) -> new Category(rs.getString("categoryName"), rs.getString("subCategoryName"), rs.getString("description")));
    }

    public void update(Category category) {
        jdbcTemplate.update("UPDATE Category SET subCategoryName=?, description=? WHERE categoryName=?",
                category.getSubCategoryName(), category.getDescription(), category.getCategoryName());
    }

}
