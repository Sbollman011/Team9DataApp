package com.example;



public class QueryIncomingOrders {

    //getters and setters for the query to generate a sales report for a specific store
    String incomingName, incomingOrderDate, incomingShipDate,incomingQuantity;

    public QueryIncomingOrders(String incomingName, String incomingOrderDate,String incomingShipDate, String incomingQuantity){
        this.incomingName= incomingName;
        this.incomingOrderDate = incomingOrderDate;
        this.incomingShipDate =incomingShipDate;
        this.incomingQuantity = incomingQuantity;
        
    }

    public String getIncomingName() {
        return incomingName;
    }

    public void setIncomingName(String incomingName) {
        this.incomingName = incomingName;
    }

    public String getIncomingOrderDate() {
        return incomingOrderDate;
    }

    public void setIncomingOrderDate(String incomingOrderDate) {
        this.incomingOrderDate = incomingOrderDate;
    }

    public String getIncomingShipDate() {
        return incomingShipDate;
    }

    public void setIncomingShipDate(String incomingShipDate) {
        this.incomingShipDate = incomingShipDate;
    }

    public String getIncomingQuantity() {
        return incomingQuantity;
    }

    public void setIncomingQuantity(String incomingQuantity) {
        this.incomingQuantity = incomingQuantity;
    }
}
   