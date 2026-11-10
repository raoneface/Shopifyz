package com.shubham.shopify.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Product {
    @Id 
    private Long id;
    private String product_name;
    private LocalDateTime createdtime;
    private LocalDateTime updatedtime; 
    private int price;
    private String category;    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
    }

    public LocalDateTime getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(LocalDateTime updatedtime) {
        this.updatedtime = updatedtime;
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
}
