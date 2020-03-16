package com.example;

public class Order {


    String orderTotal;
    String orderID,orderDate, orderShipDate, 
    orderVendorID,orderStoreID;

    public Order(String orderID, String orderDate, String orderShipDate,
        String orderTotal, String orderVendorID, String orderStoreID){

        this.orderID= orderID;
        this.orderDate = orderDate;
        this.orderShipDate= orderShipDate;
        this.orderTotal = orderTotal;
        this.orderVendorID = orderVendorID;
        this.orderStoreID = orderStoreID;
    }

    
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderShipDate(String orderShipDate) {
        this.orderShipDate = orderShipDate;
    }
    public String getOrderShipDate(){
        return orderShipDate;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderVendorID() {
        return orderVendorID;
    }

    public void setOrderVendorID(String orderVendorID) {
        this.orderVendorID =orderVendorID;
    }

    public String getOrderStoreID() {
        return orderStoreID;
    }

    public void setOrderStoreID(String orderStoreID) {
        this.orderStoreID =orderStoreID;
    }
}
