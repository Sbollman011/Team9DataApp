package com.example;

public class Category {

    
    String categoryName,subCategoryName;

    public Category(String categoryName, String subCategoryName) {
        this.categoryName= categoryName;
        this.subCategoryName = subCategoryName;
    }

    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }


}