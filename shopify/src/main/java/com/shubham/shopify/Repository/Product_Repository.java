package com.shubham.shopify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.shopify.Entity.Product;

public interface  Product_Repository extends JpaRepository<Product,Long >{
    
}
