package com.shubham.shopify.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class Product_RequestDto{

    @NotBlank (message= "name cant be empty or blank")
    private String product_name;

    @Positive  
    private Integer price;

    @NotBlank
    private String category;

    @NotBlank 
    private String description; 

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}