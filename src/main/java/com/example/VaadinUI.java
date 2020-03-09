package com.example;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import org.springframework.beans.factory.annotation.Autowired;






import java.util.*;

@SpringUI
public class VaadinUI extends UI {

//#######################CATEGORY##########################################################

    @Autowired
    private CategoryService categoryService;

    private Category category;

    private Binder<Category> categoryBinder = new Binder<>(Category.class);

    private Grid<Category> categoryGrid = new Grid(Category.class);
    private TextField categoryName = new TextField("Category Name");
    private TextField subCategoryName = new TextField("SubCategory Name");
    private Button save = new Button("Save Changes", e -> saveCategory());
    private Button insert = new Button("Insert Category", e -> insertCategory());


    //#############CUSTOMER##############################################################################################

    @Autowired
    private CustomerService customerService;

    private Customer customer;

    private Binder<Customer> customerBinder = new Binder<>(Customer.class);

    private Grid<Customer> customerGrid = new Grid(Customer.class);
    private TextField customerID = new TextField("CustomerID");
    private TextField customerFirstName  = new TextField("First Name");
    private TextField customerLastName = new TextField("Last Name");
    private TextField billAddress = new TextField("Bill Address");
    private TextField billCity = new TextField("Bill City");
    private TextField billState = new TextField("Bill State");
    private TextField billZip = new TextField("Bill Zip");
    private TextField shipAddress = new TextField("Ship Address");
    private TextField shipCity = new TextField("Ship City");
    private TextField shipState = new TextField("Ship State");
    private TextField shipZip = new TextField("Ship Zip");
    private TextField phone = new TextField("Phone");
    private TextField email = new TextField("Email");
   private Button saveCustomerButton = new Button("Save Changes", e -> saveCustomer());

   //##########################  EMPLOYEE  ############################################################
   @Autowired
   private EmployeeService employeeService;

   private Employee employee;

   private Binder<Employee> employeeBinder = new Binder<>(Employee.class);

   private Grid<Employee> employeeGrid = new Grid(Employee.class);
   private TextField employeeID = new TextField("Employee ID");
   private TextField employeeFirstName  = new TextField("First Name");
   private TextField employeeLastName = new TextField("Last Name");
   private TextField employeeStreetAddress = new TextField("Street Address");
   private TextField employeeCity = new TextField("City");
   private TextField employeeState = new TextField("State");
   private TextField employeeZip = new TextField("Zip");
   private TextField employeeStoreID = new TextField("Employee Store ID");
   private Button saveEmployeeButton = new Button("Save Changes", e -> saveEmployee());

    //#############################INIT####################################################################

    protected void init(VaadinRequest request) {

    

    //###############CATEGORY GRID CREATION#############################################
        updateGrid();

        categoryGrid.setColumns("categoryName","subCategoryName");
        categoryGrid.addSelectionListener(e -> updateForm());
        categoryBinder.bindInstanceFields(this);



     //############Customer GRID CREATION#########################################
       updateGridCustomer();
       customerGrid.setColumns("customerID","customerFirstName","customerLastName","billAddress"
       ,"billCity", "billState","billZip","shipAddress"
       ,"shipCity","shipState","shipZip","phone","email");
       customerGrid.addSelectionListener(e -> updateFormCustomer());

       customerBinder.bindInstanceFields(this);

    //########### Employee GRID CREATION ###############################################//#endregion
    updateGridEmployee();
    employeeGrid.setColumns("employeeID","employeeFirstName","employeeLastName","employeeStreetAddress"
    ,"employeeCity", "employeeState","employeeZip","employeeStoreID");

    employeeGrid.addSelectionListener(e -> updateFormEmployee());

    employeeBinder.bindInstanceFields(this);


     //#########################LAYOUT CREATION##############################################
        VerticalLayout layout = new VerticalLayout(categoryGrid, categoryName, subCategoryName, save,insert,customerGrid,
        customerID,customerFirstName,customerLastName,billAddress,billCity,billState,billZip,shipAddress,shipCity,shipState,
        shipZip,phone,email,saveCustomerButton,employeeGrid,employeeID,employeeFirstName,employeeLastName,
        employeeStreetAddress, employeeCity, employeeState, employeeZip, employeeStoreID,saveEmployeeButton);
        setContent(layout);

    }

    //########################CATEGORY FUNCTION########################################################

    private void updateGrid() {
      List<Category> categories = categoryService.findAll();
        categoryGrid.setItems(categories);
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
        save.setVisible(visible);
    }

    private void saveCategory() {
        categoryService.update(category);
        updateGrid();
    }

    private void insertCategory() {
        categoryService.insert();
        updateGrid();
    }




    //######################Customer FUNCTIONS#######################################################################################################
    private void updateGridCustomer() {
        List<Customer> customers = customerService.findAll();
          customerGrid.setItems(customers);
          setFormVisibleCustomer(false);
      }

    
    private void updateFormCustomer() {
        if (customerGrid.asSingleSelect().isEmpty()) {
            setFormVisibleCustomer(false);
        } else {
            customer = customerGrid.asSingleSelect().getValue();
            customerBinder.setBean(customer);
            setFormVisibleCustomer(true);
        }
    }

    private void setFormVisibleCustomer(boolean visible) {
        customerID.setVisible(visible);
        customerFirstName.setVisible(visible);
        customerLastName.setVisible(visible);
        billAddress.setVisible(visible);
        billCity.setVisible(visible);
        billState.setVisible(visible);
        billZip.setVisible(visible);
        shipAddress.setVisible(visible);
        shipCity.setVisible(visible);
        shipState.setVisible(visible);
        shipZip.setVisible(visible);
        phone.setVisible(visible);
        email.setVisible(visible);
        saveCustomerButton.setVisible(visible);
    }
    
    private void saveCustomer() {
        customerService.update(customer);
        updateGridCustomer();
    }
        
    


 //######################Employee FUNCTIONS#######################################################################################################
 private void updateGridEmployee() {
    List<Employee> employees = employeeService.findAll();
      employeeGrid.setItems(employees);
      setFormVisibleEmployee(false);
  }


private void updateFormEmployee() {
    if (employeeGrid.asSingleSelect().isEmpty()) {
        setFormVisibleEmployee(false);
    } else {
        employee = employeeGrid.asSingleSelect().getValue();
        employeeBinder.setBean(employee);
        setFormVisibleEmployee(true);
    }
}

private void setFormVisibleEmployee(boolean visible) {
    employeeID.setVisible(visible);
    employeeFirstName.setVisible(visible);
    employeeLastName.setVisible(visible);
    employeeStreetAddress.setVisible(visible);
    employeeCity.setVisible(visible);
    employeeState.setVisible(visible);
    employeeZip.setVisible(visible);
    employeeStoreID.setVisible(visible);
    saveEmployeeButton.setVisible(visible);
}

private void saveEmployee() {
    employeeService.update(employee);
    updateGridEmployee();
}
    

}

