package com.example;

public class Product_Ordered {

    
    String poOrderedID,productOrderedProductID,productOrderedQuantity;

    public Product_Ordered(String poOrderedID, String productOrderedProductID,String productOrderedQuantity) {
        this.poOrderedID= poOrderedID;
        this.productOrderedProductID = productOrderedProductID;
        this.productOrderedQuantity = productOrderedQuantity;
    }

    
    public String getPoOrderedID() {
        return poOrderedID;
    }

    public void setPoOrderedID(String poOrderedID) {
        this.poOrderedID = poOrderedID;
    }

    public String getproductOrderedProductID() {
        return productOrderedProductID;
    }

    public void setproductOrderedProductID(String productOrderedProductID){
        this.productOrderedProductID = productOrderedProductID;
    }

    public String getproductOrderedQuantity(){
        return productOrderedQuantity;
    }

    public void setproductOrderedQuantity(String productOrderedQuantity) {
        this.productOrderedQuantity = productOrderedQuantity;
    }




}