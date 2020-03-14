package com.example;

public class productCategories{

    String productCategoriesProductID, productCategoriesName, productCategoriesSubName;



    public productCategories(String productCategoriesProductID, String productCategoriesName,String productCategoriesSubName) {
        this.productCategoriesProductID= productCategoriesProductID;
        this.productCategoriesName = productCategoriesName;
        this.productCategoriesSubName = productCategoriesSubName;
    }

    
    public String getProductCategoriesID() {
        return productCategoriesProductID;
    }

    public void setProductCategoriesID(String productCategoriesProductID) {
        this.productCategoriesProductID = productCategoriesProductID;
    }

    public String getProductCategoriesName() {
        return productCategoriesName;
    }

    public void setProductCategoriesName(String productCategoriesName){
        this.productCategoriesName = productCategoriesName;
    }

    public String getProductCategoriesSubName(){
        return productCategoriesSubName;
    }

    public void setproductCategoriesSubName(String productCategoriesSubName) {
        this.productCategoriesSubName = productCategoriesSubName;
    }




}