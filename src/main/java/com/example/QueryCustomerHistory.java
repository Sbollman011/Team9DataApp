package com.example;



public class QueryCustomerHistory {

    //getters and setters for the query to generate a sales report for a specific store
    String customerFname, customerLname,customerTransactionID,customerPname,itemPrice;

    public QueryCustomerHistory(String customerFname, String customerLname, String customerTransactionID, String customerPname,String itemPrice) {
        this.customerFname= customerFname;
        this.customerLname = customerLname;
        this.customerTransactionID = customerTransactionID;
        this.customerPname = customerPname;
        this.itemPrice = itemPrice;
        
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public void setCustomerFName(String customerFname) {
        this.customerFname = customerFname;
    }

    public String getCustomerLname() {
        return customerLname;
    }

    public void setCustomerLname(String customerLname) {
        this.customerLname = customerLname;
    }

    public String getCustomerTransactionID() {
        return customerTransactionID;
    }

    public void setCustomerTransactionID(String customerTransactionID) {
        this.customerTransactionID = customerTransactionID;
    }

    public String getCustomerPname() {
        return customerPname;
    }

    public void setCustomerPname(String customerPname) {
        this.customerPname = customerPname;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setCustomerPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
   