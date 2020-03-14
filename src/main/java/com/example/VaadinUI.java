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


 //##########################  ORDER  ############################################################
   @Autowired
   private OrderService orderService;

   private Order order;

   private Binder<Order> orderBinder = new Binder<>(Order.class);

   private Grid<Order> orderGrid = new Grid(Order.class);
   private TextField orderID = new TextField("Order ID");
   private TextField orderDate  = new TextField("Order Date");
   private TextField orderShipDate = new TextField("Order Ship Date");
   private TextField orderTotal = new TextField("Order Total");
   private TextField orderVendorID = new TextField("Order Vendor ID");
   private TextField orderStoreID = new TextField("Order Store ID");
   private Button saveOrderButton = new Button("Save Changes", e -> saveOrder());

   //#######################PRODUCT##########################################################

   @Autowired
   private ProductService productService ;

   private Product product;

   private Binder<Product> productBinder = new Binder<>(Product.class);

   private Grid<Product> productGrid = new Grid(Product.class);
   private TextField productID = new TextField("Product ID");
   private TextField productName = new TextField("Product Name");
   private TextField productDescription = new TextField("Product Description");
   private TextField productPrice = new TextField("Product Price");
   private Button saveProduct = new Button("Save Changes", e -> saveProduct());
   //private Button insertProduct = new Button("Insert Category", e -> insertCategory());


   //#######################Product_Order ##########################################################

   @Autowired
   private Product_OrderedService productOrderedService;

   private Product_Ordered product_ordered;

   private Binder<Product_Ordered> productOrderedBinder = new Binder<>(Product_Ordered.class);

   private Grid<Product_Ordered> productOrderedGrid = new Grid(Product_Ordered.class);
   private TextField poOrderedID = new TextField("Product Ordered ID");
   private TextField productOrderedProductID = new TextField("Product Ordered Product ID");
   private TextField productOrderedQuantity = new TextField("Product Ordered Quantity");
   private Button saveProductOrdered = new Button("Save Changes", e -> saveProductOrdered());
   //private Button insert = new Button("Insert Category", e -> insertCategory());

    //#######################Product_Order ##########################################################

    @Autowired

    
    private productCategoriesService productcategoriesService;
    private productCategories productcategories;
    

    private Binder<productCategories> productCategoriesBinder = new Binder<>(productCategories.class);

    private Grid<productCategories> productCategoriesGrid = new Grid(productCategories.class);
    private TextField productCategoriesProductID = new TextField("Product ID");
    private TextField productCategoriesName = new TextField("Product Category Name");
    private TextField productCategoriesSubName = new TextField("Product Ordered Quantity");
    private Button saveProductCategories = new Button("Save Changes", e -> saveProductCategories());
    //private Button insert = new Button("Insert Category", e -> insertCategory());
   
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

    //########### Order GRID CREATION ###############################################//#endregion
    updateGridOrder();
    orderGrid.setColumns("orderID","orderDate","orderShipDate","orderTotal"
    ,"orderVendorID", "orderStoreID");

    orderGrid.addSelectionListener(e -> updateFormOrder());

    orderBinder.bindInstanceFields(this);

     //###############Product Grid Creation#############################################
     updateGridProduct();

     productGrid.setColumns("productID","productName","productDescription","productPrice");
     productGrid.addSelectionListener(e -> updateFormProduct());
     productBinder.bindInstanceFields(this);

    //###############Product Ordered Grid Creation#############################################
    updateGridProductOrdered();

    productOrderedGrid.setColumns("poOrderedID","productOrderedProductID","productOrderedQuantity");
    productOrderedGrid.addSelectionListener(e -> updateFormProductOrdered());
    productOrderedBinder.bindInstanceFields(this);
   
   //###############ProductCategories Creation #############################################
   updateGridProductCategories();

   //productCategoriesGrid.setColumns("productCategoriesProductID","productCategoryName","ProductCategorySubName");
   productCategoriesGrid.addSelectionListener(e -> updateFormProductCategories());
   productCategoriesBinder.bindInstanceFields(this);
  


     //#########################LAYOUT CREATION##############################################
    VerticalLayout layout = new VerticalLayout(categoryGrid, categoryName, subCategoryName, save,insert,customerGrid,
    customerID,customerFirstName,customerLastName,billAddress,billCity,billState,billZip,shipAddress,shipCity,shipState,
    shipZip,phone,email,saveCustomerButton,employeeGrid,employeeID,employeeFirstName,employeeLastName,
    employeeStreetAddress, employeeCity, employeeState, employeeZip, employeeStoreID,saveEmployeeButton,orderGrid,orderID,orderDate,orderShipDate,
    orderTotal,orderVendorID,orderStoreID,saveOrderButton,productGrid,productID,productName,productDescription,productPrice,saveProduct, productOrderedGrid,
    poOrderedID, productOrderedProductID, productOrderedQuantity,saveProductOrdered,productCategoriesGrid,productCategoriesProductID, productCategoriesName,productCategoriesSubName);
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
    


 //######################Order FUNCTIONS#######################################################################################################
 private void updateGridOrder() {
    List<Order> orders = orderService.findAll();
      orderGrid.setItems(orders);
      setFormVisibleOrder(false);
  }


private void updateFormOrder() {
    if (orderGrid.asSingleSelect().isEmpty()) {
        setFormVisibleOrder(false);
    } else {
        order = orderGrid.asSingleSelect().getValue();
        orderBinder.setBean(order);
        setFormVisibleOrder(true);
    }
}

private void setFormVisibleOrder(boolean visible) {
    orderID.setVisible(visible);
    orderDate.setVisible(visible);
    orderShipDate.setVisible(visible);
    orderTotal.setVisible(visible);
    orderVendorID.setVisible(visible);
    orderStoreID.setVisible(visible);
    
}

private void saveOrder() {
    orderService.update(order);
    updateGridOrder();
}
   //########################PRODUCT FUNCTION########################################################

   private void updateGridProduct() {
    List<Product> products = productService.findAll();
      productGrid.setItems(products);
      setFormVisibleProduct(false);
  }


  private void updateFormProduct() {
      if (productGrid.asSingleSelect().isEmpty()) {
          setFormVisibleProduct(false);
      } else {
          product = productGrid.asSingleSelect().getValue();
          productBinder.setBean(product);
          setFormVisibleProduct(true);
      }
  }

  private void setFormVisibleProduct(boolean visible) {
      productID.setVisible(visible);
      productName.setVisible(visible);
      productDescription.setVisible(visible);
      productPrice.setVisible(visible);
      save.setVisible(visible);
  }

  private void saveProduct() {
      productService.update(product);
      updateGridProduct();
  }

  /*private void insertProduct() {
      categoryService.insert();
      updateGridProduct();*/
  //} 

   //########################Product Ordered FUNCTIONS########################################################

   private void updateGridProductOrdered() {
    List<Product_Ordered> productsOrdered = productOrderedService.findAll();
      productOrderedGrid.setItems(productsOrdered);
      setFormVisibleProductOrdered(false);
  }


  private void updateFormProductOrdered() {
      if (productOrderedGrid.asSingleSelect().isEmpty()) {
          setFormVisibleProductOrdered(false);
      } else {
          product_ordered = productOrderedGrid.asSingleSelect().getValue();
          productOrderedBinder.setBean(product_ordered);
          setFormVisibleProductOrdered(true);
      }
  }

  private void setFormVisibleProductOrdered(boolean visible) {
      poOrderedID.setVisible(visible);
      productOrderedProductID.setVisible(visible);
      productOrderedQuantity.setVisible(visible);

      saveProductOrdered.setVisible(visible);
  }

  private void saveProductOrdered() {
      productOrderedService.update(product_ordered);
      updateGridProductOrdered();
  }


  /*private void insertCate() {
      categoryService.insert();
      updateGrid();
  }*/

   //########################Product Ordered FUNCTIONS########################################################

   private void updateGridProductCategories() {
    List<productCategories> ProductCategories = productcategoriesService.findAll();
      productCategoriesGrid.setItems(ProductCategories);
      setFormVisibleProductOrdered(false);
  }


  private void updateFormProductCategories() {
      if (productCategoriesGrid.asSingleSelect().isEmpty()) {
          setFormVisibleProductCategories(false);
      } else {
          productcategories = productCategoriesGrid.asSingleSelect().getValue();
          productCategoriesBinder.setBean(productcategories);
          setFormVisibleProductOrdered(true);
      }
  }

  private void setFormVisibleProductCategories(boolean visible) {
      productCategoriesProductID.setVisible(visible);
      productCategoriesName.setVisible(visible);
      productCategoriesSubName.setVisible(visible);

      saveProductCategories.setVisible(visible);
  }

  private void saveProductCategories() {
      productcategoriesService.update(productcategories);
      updateGridProductCategories();
  }
}

  /*private void insertCate() {
      categoryService.insert();
      updateGrid();
  }*/


