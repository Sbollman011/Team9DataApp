package com.example;

public class Store {
    String storeStoreID,storeStreetAdd, storeCity, storeState,storeZIP;

    public Store(String storeStoreID, String storeStreetAdd, String storeCity,
     String storeState, String storeZIP){

        this.storeStoreID= storeStoreID;
        this.storeStreetAdd = storeStreetAdd;
        this.storeCity= storeCity;
        this.storeState = storeState;
        this.storeZIP = storeZIP;
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

    public String getStoreState(){
        return storeState;
    }
   public String getStoreZIP(){
        return storeZIP;
    }
};