package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class QuerySalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QuerySalesReport> findAll() {
        return jdbcTemplate.query("SELECT * FROM `Team9RetailManagementDB`.`Transaction`WHERE Transaction.TRANS_StoreID = 9 ORDER BY OrderDate DESC",
        
                (rs, rowNum) -> new QuerySalesReport(rs.getString("TransactionID"),rs.getString("OrderDate"),rs.getString("ShipDate"),
                rs.getString("Total"),rs.getString("TRANS_CustomerID"),rs.getString("TRANS_EmployeeID"),rs.getString("TRANS_StoreID")));
    }

}
