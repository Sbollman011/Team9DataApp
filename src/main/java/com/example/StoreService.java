package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class StoreService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Store> findAll() {
        return jdbcTemplate.query("Select * From Store",
        
        (rs, rowNum) -> new Store(rs.getString("StoreID"),rs.getString("StreetAddress"),rs.getString("City"),
        rs.getString("State"),rs.getString("ZIP")));
    }
}