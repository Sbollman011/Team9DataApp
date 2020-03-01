package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Employee_TransactionsService {

    @Autowired
    private JdbcTemplate jdbcTemplateET;

    public List<Employee_Transaction> findAll() {
        return jdbcTemplateET.query("SELECT EmployeeID, TransactionID FROM Employee_Transactions;",
                (rs, rowNum) -> new Employee_Transaction(rs.getString("EmployeeID"), rs.getString("TransactionID")));
    }

    public void update(Employee_Transaction employee_Transaction) {
        jdbcTemplateET.update("UPDATE Employee_Transaction SET EmployeeID=?, TransactionID=?",
                employee_Transaction.getEmployeeID(), employee_Transaction.getTransactionID());
    }

}
