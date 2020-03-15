package com.example;



public class QueryCheckInventory {

    //getters and setters for the query to generate a sales report for a specific store
    String storeNo, productName, description, stock;

    public QueryCheckInventory(String storeNo,String productName, String description, String stock) {
        this.storeNo= storeNo;
        this.productName = productName;
        this.description = description;
        this.stock = stock;
     

    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }



}