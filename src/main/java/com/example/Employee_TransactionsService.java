package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Employee_TransactionsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;    

    public List<Employee_Transaction> findAll() {
        return jdbcTemplate.query("SELECT EmployeeID, TransactionID FROM Employee_Transactions",
                (rs, rowNum) -> new Employee_Transaction(rs.getString("EmployeeID"), rs.getString("TransactionID")));
        

    }

    public void update(Employee_Transaction employee_Transaction) {
        jdbcTemplate.update("UPDATE Employee_Transactions SET EmployeeID=?, TransactionID=?",
                employee_Transaction.getEmployeeID(), employee_Transaction.getTransactionID());
    }

}
