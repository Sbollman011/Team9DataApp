package com.example;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@SpringUI
public class VaadinUI extends UI {


    @Autowired
    private CategoryService categoryService;

    private Category category;

    private Binder<Category> categoryBinder = new Binder<>(Category.class);

    private Grid<Category> categoryGrid = new Grid(Category.class);
    private TextField categoryName = new TextField("Category Name");
    private TextField subCategoryName = new TextField("SubCategory Name");
    private TextField description = new TextField("Description");
    private Button save = new Button("Save", e -> saveCategory());

    //##########EMPLOYEE##################################################################

    private Employee_TransactionsService employeeTransactionService;

    private Employee_Transaction employeeTransaction;

    private Binder<Employee_Transaction> employeeTransactionBinder = new Binder<>(Employee_Transaction.class);

    private Grid<Employee_Transaction> employeeTransactionGrid = new Grid(Employee_Transaction.class);
    private TextField employeeID = new TextField("EmployeeID");
    private TextField transactionID  = new TextField("TransactionID");
    private Button save1 = new Button("Save", e -> saveEmployeeTransaction());
    //#################################################################################################

    protected void init(VaadinRequest request) {

       //updateGridET();
        updateGrid();

        categoryGrid.setColumns("categoryName","subCategoryName", "description");
        categoryGrid.addSelectionListener(e -> updateForm());

        categoryBinder.bindInstanceFields(this);


       
        employeeTransactionGrid.setColumns("employeeID","transactionID");
        employeeTransactionGrid.addSelectionListener(e -> updateFormET());

        employeeTransactionBinder.bindInstanceFields(this);

        VerticalLayout layout = new VerticalLayout(categoryGrid, categoryName, subCategoryName, description, save,employeeTransactionGrid,employeeID,transactionID,save1);
        setContent(layout);

      

    }


    private void updateGrid() {
      List<Category> categories = categoryService.findAll();
        categoryGrid.setItems(categories);
        setFormVisible(false);
    }

    
    private void updateGridET() {
      List<Employee_Transaction> employeeTransactions = employeeTransactionService.findAll();
       employeeTransactionGrid.setItems(employeeTransactions);
        setFormVisible(false);

        


    }

    private void updateForm() {
        if (categoryGrid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            category = categoryGrid.asSingleSelect().getValue();
            categoryBinder.setBean(category);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        categoryName.setVisible(visible);
        subCategoryName.setVisible(visible);
        description.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCategory() {
        categoryService.update(category);
        updateGrid();
    }


//#############################################################################################################################


    private void updateFormET() {
        if (employeeTransactionGrid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
            employeeTransaction = employeeTransactionGrid.asSingleSelect().getValue();
            employeeTransactionBinder.setBean(employeeTransaction);
            setFormVisible(true);
        }
    }

    private void setFormVisibleET(boolean visible) {
        employeeID.setVisible(visible);
        transactionID.setVisible(visible);
        save.setVisible(visible);
    }
    
    private void saveEmployeeTransaction() {
        employeeTransactionService.update(employeeTransaction);
        updateGridET();
    }
    
    
}
