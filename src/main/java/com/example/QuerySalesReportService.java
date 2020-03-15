package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.util.*;

@Component
public class QuerySalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QuerySalesReport> findAll(String store) {
        return jdbcTemplate.query("SELECT * FROM `Team9RetailManagementDB`.`Transaction`WHERE Transaction.TRANS_StoreID = "+ store +" ORDER BY OrderDate DESC",
        
                (rs, rowNum) -> new QuerySalesReport(rs.getString("TransactionID"),rs.getString("OrderDate"),rs.getString("ShipDate"),
                rs.getString("Total"),rs.getString("TRANS_CustomerID"),rs.getString("TRANS_EmployeeID"),rs.getString("TRANS_StoreID")));
    }

    public void update(QuerySalesReport query) {
        jdbcTemplate.update("UPDATE Transaction SET TransactionID=?, OrderDate=?, ShipDate=?, Total=?, TRANS_CustomerID=?, TRANS_EmployeeID=?, TRANS_StoreID=? WHERE TRANS_StoreID=?",
              query.getSalesTransactionID(), query.getSalesOrderDate(), query.getSalesShipDate(),query.getSalesTotal(),query.getSalesCustomerID(),
              query.getSalesEmployeeID());
    }
}
