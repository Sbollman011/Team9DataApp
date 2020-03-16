package com.example;

public class StoreInventory {
    String storeStoreID,storeStreetAdd, storeCity;

    public StoreInventory(String storeStoreID, String storeStreetAdd, String storeCity){

        this.storeStoreID= storeStoreID;
        this.storeStreetAdd = storeStreetAdd;
        this.storeCity= storeCity;
   
    }

    public String getStoreID(){
        return storeStoreID;
    }

    public String getStoreStreetAdd(){
        return storeStreetAdd;
    }

    public String getStoreCity(){
        return storeCity;
    }

};