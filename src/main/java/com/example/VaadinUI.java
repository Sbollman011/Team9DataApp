package com.example;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.html.HTMLLabelElement;

import java.util.*;

@SpringUI
public class VaadinUI extends UI {

//############################TITLE################################################
Label Title = new Label("<b><font size=32 color=navy>Team 9 Inventory Solutions</font></b>",ContentMode.HTML);

Label QueriesLabel = new Label("<b><font size=18 color=dodgerblue>Useful Queries</font></b>",ContentMode.HTML);

Label dbTableLabel = new Label("<b><font size=18 color=dodgerblue>Database Tables</font></b>",ContentMode.HTML);
//#######################CATEGORY##########################################################

    @Autowired
    private CategoryService categoryService;
    
    private Category category;

    private   Binder<Category> categoryBinder = new Binder<>(Category.class);

    Label CategoryLabel = new Label("<b><font size=10 color=black>Categories</font></b>",ContentMode.HTML);


    private   Grid<Category> categoryGrid = new Grid(Category.class);
    private   TextField categoryName = new TextField("Category Name");
    private   TextField subCategoryName = new TextField("SubCategory Name");
    private   Button save = new Button("Save Changes", e -> saveCategory());
    private   Button insert = new Button("Insert Category", e -> insertCategory());


    //#############CUSTOMER##############################################################################################

    @Autowired
    private CustomerService customerService;

    private Customer customer;

    private   Binder<Customer> customerBinder = new Binder<>(Customer.class);

    Label CustomerLabel = new Label("<b><font size=10 color=black>Customers</font></b>",ContentMode.HTML);

    private   Grid<Customer> customerGrid = new Grid(Customer.class);
    private   TextField customerID = new TextField("CustomerID");
    private   TextField customerFirstName  = new TextField("First Name");
    private   TextField customerLastName = new TextField("Last Name");
    private   TextField billAddress = new TextField("Bill Address");
    private   TextField billCity = new TextField("Bill City");
    private   TextField billState = new TextField("Bill State");
    private   TextField billZip = new TextField("Bill Zip");
    private   TextField shipAddress = new TextField("Ship Address");
    private   TextField shipCity = new TextField("Ship City");
    private   TextField shipState = new TextField("Ship State");
    private   TextField shipZip = new TextField("Ship Zip");
    private   TextField phone = new TextField("Phone");
    private   TextField email = new TextField("Email");
   private   Button saveCustomerButton = new Button("Save Changes", e -> saveCustomer());

   //##########################  EMPLOYEE  ############################################################
   @Autowired
   private EmployeeService employeeService;

   private Employee employee;

   private   Binder<Employee> employeeBinder = new Binder<>(Employee.class);

   Label employeeLabel = new Label("<b><font size=10 color=black>Employees</font></b>",ContentMode.HTML);

   private   Grid<Employee> employeeGrid = new Grid(Employee.class);
   private   TextField employeeID = new TextField("Employee ID");
   private   TextField employeeFirstName  = new TextField("First Name");
   private   TextField employeeLastName = new TextField("Last Name");
   private   TextField employeeSalary = new TextField("Salary");
   private   TextField employeeStreetAddress = new TextField("Street Address");
   private   TextField employeeCity = new TextField("City");
   private   TextField employeeState = new TextField("State");
   private   TextField employeeZip = new TextField("Zip");
   private   TextField employeeStoreID = new TextField("Employee Store ID");
   private   Button saveEmployeeButton = new Button("Save Changes", e -> saveEmployee());


 //##########################  ORDER  ############################################################
   @Autowired
   private OrderService orderService;

   private Order order;

   private   Binder<Order> orderBinder = new Binder<>(Order.class);

   Label orderLabel = new Label("<b><font size=10 color=black>Orders</font></b>",ContentMode.HTML);

   private   Grid<Order> orderGrid = new Grid(Order.class);
   private   TextField orderID = new TextField("Order ID");
   private   TextField orderDate  = new TextField("Order Date");
   private   TextField orderShipDate = new TextField("Order Ship Date");
   private   TextField orderTotal = new TextField("Order Total");
   private   TextField orderVendorID = new TextField("Order Vendor ID");
   private   TextField orderStoreID = new TextField("Order Store ID");
   private   Button saveOrderButton = new Button("Save Changes", e -> saveOrder());

   //#######################PRODUCT##########################################################

   @Autowired
   private ProductService productService ;

   private Product product;

   private   Binder<Product> productBinder = new Binder<>(Product.class);

   Label productLabel = new Label("<b><font size=10 color=black>Products</font></b>",ContentMode.HTML);

   private   Grid<Product> productGrid = new Grid(Product.class);
   private   TextField productID = new TextField("Product ID");
   private   TextField productName = new TextField("Product Name");
   private   TextField productDescription = new TextField("Product Description");
   private   TextField productPrice = new TextField("Product Price");
   private   Button saveProduct = new Button("Save Changes", e -> saveProduct());
   //private Button insertProduct = new Button("Insert Category", e -> insertCategory());


   //#######################Product_Order ##########################################################

   @Autowired
   private Product_OrderedService productOrderedService;

   private Product_Ordered product_ordered;

   private   Binder<Product_Ordered> productOrderedBinder = new Binder<>(Product_Ordered.class);

   Label productOrderedLabel = new Label("<b><font size=10 color=black>Products Ordered</font></b>",ContentMode.HTML);

   private   Grid<Product_Ordered> productOrderedGrid = new Grid(Product_Ordered.class);
   private   TextField poOrderedID = new TextField("Product Ordered ID");
   private   TextField productOrderedProductID = new TextField("Product Ordered Product ID");
   private   TextField productOrderedQuantity = new TextField("Product Ordered Quantity");
   private   Button saveProductOrdered = new Button("Save Changes", e -> saveProductOrdered());
   //private Button insert = new Button("Insert Category", e -> insertCategory());

    //#######################Product_Order ##########################################################

    @Autowired
    private productCategoriesService productcategoriesService;
    private productCategories productcategories;
    

    private   Binder<productCategories> productCategoriesBinder = new Binder<>(productCategories.class);

    Label productCategoriesLabel = new Label("<b><font size=10 color=black>Product Categories</font></b>",ContentMode.HTML);

    private   Grid<productCategories> productCategoriesGrid = new Grid(productCategories.class);
    private   TextField productCategoriesProductID = new TextField("Product ID");
    private   TextField productCategoriesName = new TextField("Product Category Name");
    private   TextField productCategoriesSubName = new TextField("Product Ordered Quantity");
    private   Button saveProductCategories = new Button("Save Changes", e -> saveProductCategories());
    //private Button insert = new Button("Insert Category", e -> insertCategory());

     //#######################Product_SOLD##########################################################

 
     private ProductSold productSold;
     @Autowired
     private ProductSoldService productSoldService;
     
 
     private   Binder<ProductSold> productSoldBinder = new Binder<>(ProductSold.class);
 
     Label productSoldLabel = new Label("<b><font size=10 color=black>Products Sold</font></b>",ContentMode.HTML);
 
     private   Grid<ProductSold> productSoldGrid = new Grid(ProductSold.class);
     private TextField productSoldID = new TextField("Product Sold ID");
     private TextField productSoldTransactionID = new TextField("Product Sold Transaction ID");
     private TextField productSoldQuantity = new TextField("Product Sold Quantity");
     private Button saveProductSold = new Button("Save Changes", e -> saveProductSold());
         //private Button insert = new Button("Insert Category", e -> insertCategory());
   

  //###########################Pull Store Sales Report SQL QUERIES###################################################

 
  private QuerySalesReport querySalesReport;
  @Autowired
  private QuerySalesReportService querySalesReportService;
  

  private   Binder<QuerySalesReport> querySalesReportBinder = new Binder<>(QuerySalesReport.class);
  private Grid<QuerySalesReport> querySalesReportGrid = new Grid(QuerySalesReport.class);

  Label salesReport = new Label("<p><font size=7 color=navy>Pull a Stores Sales report for a given store.</font></p>",ContentMode.HTML);
  Label salesReport1 = new Label("<p><font size=4 color=black>Please enter your valid store ID to generate your transactions.</font></p>",ContentMode.HTML);

  private TextField saleReportStoreID = new TextField("Store ID");
  private Button generateReport = new Button("Generate Report", e -> generateSalesReport());

  //###########################Pull Employee Sales Report SQL QUERIES###################################################

 
  private QueryEmployeeSalesReport queryEmployeeSalesReport;
  @Autowired
  private QueryEmployeeSalesReportService queryEmployeeSalesReportService;
  

  private   Binder<QueryEmployeeSalesReport> queryEmployeeSalesReportBinder = new Binder<>(QueryEmployeeSalesReport.class);
  private Grid<QueryEmployeeSalesReport> queryEmployeeSalesReportGrid = new Grid(QueryEmployeeSalesReport.class);

  Label EmployeeSalesReport = new Label("<p><font size=7 color=navy>Pull Employee Sales records for all employees.</font></p>",ContentMode.HTML);
  
//###########################Check Store Inventory SQL QUERIES###################################################

 
private QueryCheckInventory queryCheckInventory;
@Autowired
private QueryCheckInventoryService queryCheckInventoryService;


private   Binder<QueryCheckInventory> queryCheckInventoryBinder = new Binder<>(QueryCheckInventory.class);
private Grid<QueryCheckInventory> queryCheckInventoryGrid = new Grid(QueryCheckInventory.class);

Label checkInventoryLabel = new Label("<p><font size=7 color=navy>Check the Inventory of a store</font></p>",ContentMode.HTML);
Label checkInventoryLabel1 = new Label("<p><font size=4 color=black>Please enter a valid store ID to generate an inventory report.</font></p>",ContentMode.HTML);

private TextField inventoryReportID = new TextField("Store ID");
private Button generateInventoryReport = new Button("Generate Report", e -> generateInventoryReport());
    //#############################INIT####################################################################

    protected void init(  VaadinRequest request) {

    

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
    employeeGrid.setColumns("employeeID","employeeFirstName","employeeLastName","salary","employeeStreetAddress"
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


   //###############Product Sold Grid Creation#############################################
   updateGridProductSold();

   productSoldGrid.setColumns("soldTransactionID","soldProductID","soldQuantity");
   productSoldGrid.addSelectionListener(e -> updateFormProductSold());
   //productSoldBinder.bindInstanceFields(this);
  
    //###############QuerySalesReport Grid Creation#############################################

     querySalesReportGrid.setColumns("salesTransactionID","salesOrderDate","salesShipDate","salesTotal","salesCustomerID",
     "salesEmployeeID","salesStoreID");

      //###############QueryEmployeeSalesReport Grid Creation#############################################

      updateGridEmployeeSalesReport();

      queryEmployeeSalesReportGrid.setColumns("employeeNo","noOfSales");

      //###############QuerySalesReport Grid Creation#############################################

     queryCheckInventoryGrid.setColumns("storeNo","productName","description","stock");
 

     //#########################LAYOUT CREATION##############################################
    categoryGrid.setWidth("1000px"); employeeGrid.setWidth("1000px"); orderGrid.setWidth("1000px"); productGrid.setWidth("1000px");
    productOrderedGrid.setWidth("1000px"); productCategoriesGrid.setWidth("1000px"); customerGrid.setWidth("1000px");
   productSoldGrid.setWidth("1000px"); querySalesReportGrid.setWidth("1000px"); queryCheckInventoryGrid.setWidth("1000px");
   queryEmployeeSalesReportGrid.setWidth("1000px");

      VerticalLayout layout = new VerticalLayout(Title,QueriesLabel,salesReport, salesReport1,saleReportStoreID,generateReport,
    querySalesReportGrid,EmployeeSalesReport,queryEmployeeSalesReportGrid,checkInventoryLabel,checkInventoryLabel1,inventoryReportID,
    generateInventoryReport,queryCheckInventoryGrid,
    dbTableLabel,CategoryLabel, categoryGrid, categoryName, subCategoryName, save,insert,CustomerLabel,customerGrid,
    customerID,customerFirstName,customerLastName,billAddress,billCity,billState,billZip,shipAddress,shipCity,shipState,
    shipZip,phone,email,saveCustomerButton,employeeLabel,employeeGrid,employeeID,employeeFirstName,employeeLastName,employeeSalary,
    employeeStreetAddress, employeeCity, employeeState, employeeZip, employeeStoreID,saveEmployeeButton,orderLabel, orderGrid,orderID,orderDate,orderShipDate,
    orderTotal,orderVendorID,orderStoreID,saveOrderButton,productLabel, productGrid,productID,productName,productDescription,productPrice,saveProduct, 
    productOrderedLabel, productOrderedGrid,poOrderedID, productOrderedProductID, productOrderedQuantity,saveProductOrdered,productCategoriesLabel,
    productCategoriesGrid,productCategoriesProductID, productCategoriesName,productCategoriesSubName,saveProductCategories,productSoldLabel,
     productSoldGrid,productSoldTransactionID,productSoldID,productSoldQuantity,saveProductSold);
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

    private void setFormVisible(  boolean visible) {
        categoryName.setVisible(visible);
        subCategoryName.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCategory() {
      String cName = categoryName.getValue();
      String cSubName =  subCategoryName.getValue();
      categoryService.update(cName,cSubName);
      updateGrid();
    }

    private void insertCategory() {
      String cName = categoryName.getValue();
      String cSubName =  subCategoryName.getValue();
      categoryService.insert(cName,cSubName);
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

    private void setFormVisibleCustomer(  boolean visible) {
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
        customer.setCustomerID(customerID.getValue());
        customer.setCustomerFirstName(customerFirstName.getValue());
        customer.setCustomerLastName(customerLastName.getValue());
        customer.setBillAddress(billAddress.getValue());
        customer.setBillCity(billCity.getValue());
        customer.setBillState(billState.getValue());
        customer.setBillZip(billZip.getValue());
        customer.setShipAddress(shipAddress.getValue());
        customer.setShipCity(shipCity.getValue());
        customer.setShipState(shipState.getValue());
        customer.setShipZip(shipZip.getValue());
        customer.setPhone(phone.getValue());
        customer.setEmail(email.getValue());
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

private void setFormVisibleEmployee(  boolean visible) {
    employeeID.setVisible(visible);
    employeeFirstName.setVisible(visible);
    employeeLastName.setVisible(visible);
    employeeSalary.setVisible(visible);
    employeeStreetAddress.setVisible(visible);
    employeeCity.setVisible(visible);
    employeeState.setVisible(visible);
    employeeZip.setVisible(visible);
    employeeStoreID.setVisible(visible);
    saveEmployeeButton.setVisible(visible);
}

private void saveEmployee() {
    String eID = employeeID.getValue();
    String eFname =employeeFirstName.getValue();
    String eLname = employeeLastName.getValue();
    String eSalary =employeeSalary.getValue();
    String eAddress = shipAddress.getValue();
    String eCity = shipCity.getValue();
    String eState = shipState.getValue();
    String eZip = shipZip.getValue();
    String eStoreID = employeeStoreID.getValue();
    employeeService.update( eFname,  eLname,  eSalary,  eAddress,  eCity,  eState,  eZip,  eStoreID,  eID);
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

private void setFormVisibleOrder(  boolean visible) {
    orderID.setVisible(visible);
    orderDate.setVisible(visible);
    orderShipDate.setVisible(visible);
    orderShipDate.setVisible(visible);
    orderTotal.setVisible(visible);
    orderVendorID.setVisible(visible);
    orderStoreID.setVisible(visible);
    
}

private void saveOrder() {
    String oID = orderID.getValue();
    String oDate =(orderDate.getValue());
    String oShipDate = (orderShipDate.getValue());
    String oTotal = (orderTotal.getValue());
    String oVendorID =(orderVendorID.getValue());
    String oStoreID = (orderStoreID.getValue());
    orderService.update(oID,oDate,oShipDate,oTotal,oVendorID,oStoreID);
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

  private void setFormVisibleProduct(  boolean visible) {
      productID.setVisible(visible);
      productName.setVisible(visible);
      productDescription.setVisible(visible);
      productPrice.setVisible(visible);
      save.setVisible(visible);
  }

  private void saveProduct() {
      product.setProductID(productID.getValue());
      product.setProductName(productName.getValue());
      product.setProductDescription(productDescription.getValue());
      product.setProductPrice(productPrice.getValue());
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

  private void setFormVisibleProductOrdered(  boolean visible) {
      poOrderedID.setVisible(visible);
      productOrderedProductID.setVisible(visible);
      productOrderedQuantity.setVisible(visible);

      saveProductOrdered.setVisible(visible);
  }

  private void saveProductOrdered() {
      product_ordered.setPoOrderedID(poOrderedID.getValue());
      product_ordered.setproductOrderedProductID(productOrderedProductID.getValue());
      product_ordered.setproductOrderedQuantity(productOrderedQuantity.getValue());
      productOrderedService.update(product_ordered);
      updateGridProductOrdered();
  }


  /*private void insertCate() {
      categoryService.insert();
      updateGrid();
  }*/

   //########################Product Categories FUNCTIONS########################################################

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

  private void setFormVisibleProductCategories(  boolean visible) {
      productCategoriesProductID.setVisible(visible);
      productCategoriesName.setVisible(visible);
      productCategoriesSubName.setVisible(visible);

      saveProductCategories.setVisible(visible);
  }

  private void saveProductCategories() {
      productcategories.setProductCategoriesID(productCategoriesProductID.getValue());
      productcategories.setProductCategoriesName(productCategoriesName.getValue());
      productcategories.setproductCategoriesSubName(productCategoriesSubName.getValue());
      productcategoriesService.update(productcategories);
      updateGridProductCategories();
  }



  /*private void insertCate() {
      categoryService.insert();
      updateGrid();
  }*/

   //########################Product SOLD FUNCTIONS########################################################

   private void updateGridProductSold() {
      List<ProductSold> productsSold = productSoldService.findAll();
      productSoldGrid.setItems(productsSold);
      setFormVisibleProductSold(false);
  }


  private void updateFormProductSold() {
      if (productSoldGrid.asSingleSelect().isEmpty()) {
          setFormVisibleProductSold(false);
      } else {
          productSold = productSoldGrid.asSingleSelect().getValue();
          productSoldBinder.setBean(productSold);
          setFormVisibleProductOrdered(true);
      }
  }

  private void setFormVisibleProductSold(  boolean visible) {

  }

  private void saveProductSold() {
    productSold.setSoldProductID(productSoldID.getValue());
    productSold.setSoldQuantity(productSoldQuantity.getValue());
    productSold.setSoldTransactionID(productSoldTransactionID.getValue());
    productSoldService.update(productSold);
      updateGridProductSold();
  }


 /*private void insertCate() {
      categoryService.insert();
      updateGrid();
  }*/

   //########################Store Sales Report FUNCTIONS########################################################
   private void updateGridSalesReport(String store) {
    List<QuerySalesReport> salesReport = querySalesReportService.findAll(store);
    querySalesReportGrid.setItems(salesReport);
    setFormVisibleProductSold(false);
   }

   private void generateSalesReport(){
     String store =  saleReportStoreID.getValue();
       updateGridSalesReport(store);
   }


 //########################Employee Sales Report FUNCTIONS########################################################
 private void updateGridEmployeeSalesReport() {
    List<QueryEmployeeSalesReport> employeeSalesReport = queryEmployeeSalesReportService.findAll();
    queryEmployeeSalesReportGrid.setItems(employeeSalesReport);
    setFormVisibleProductSold(false);
   }

   //########################Check Inventory FUNCTIONS########################################################
   private void updateGridCheckInventory(String store) {
    List<QueryCheckInventory> checkInventory = queryCheckInventoryService.findAll(store);
    queryCheckInventoryGrid.setItems(checkInventory);
    setFormVisibleProductSold(false);
   }

   private void generateInventoryReport(){
     String store =  inventoryReportID.getValue();
       updateGridCheckInventory(store);
   }









}