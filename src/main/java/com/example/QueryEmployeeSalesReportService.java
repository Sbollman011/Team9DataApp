package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class QueryEmployeeSalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QueryEmployeeSalesReport> findAll() {
        return jdbcTemplate.query("SELECT TRANS_EmployeeID AS 'Employee Number', COUNT(*) AS 'Number of Sales' " +
        "FROM TRANSACTION " +
        "GROUP BY TRANS_EmployeeID " +
        "ORDER BY COUNT(*) DESC",
        (rs, rowNum) -> new QueryEmployeeSalesReport(rs.getString("Employee Number"),rs.getString("Number of Sales")));
    }
}