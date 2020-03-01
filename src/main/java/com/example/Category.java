package com.example;

public class Category {

    
    String categoryName,subCategoryName,description;

    public Category(String categoryName, String subCategoryName, String description) {
        this.categoryName= categoryName;
        this.subCategoryName = subCategoryName;
        this.description= description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}