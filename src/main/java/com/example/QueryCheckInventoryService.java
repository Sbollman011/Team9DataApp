package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class QueryCheckInventoryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QueryCheckInventory> findAll(String invStoreID) {
        return jdbcTemplate.query(" SELECT INV_StoreID AS 'Store Number', Name, Description, Stock " +
        "FROM Product,STORE_INVENTORY " +
        "WHERE INV_ProductID = ProductID AND INV_StoreID =" + invStoreID
        , (rs, rowNum) -> new QueryCheckInventory(rs.getString("Store Number"),rs.getString("Name"),rs.getString("Description"),
                rs.getString("Stock")));
    }


}