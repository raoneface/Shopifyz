package com.shubham.shopify.Service;

import org.springframework.stereotype.Service;
import com.shubham.shopify.Entity.Product;
import com.shubham.shopify.Repository.Product_Repository;

@Service
public class Product_Service {
     Product_Repository product_Repository;

    public Product_Service(Product_Repository product_Repository) {
        this.product_Repository = product_Repository;
    }

    public Product addProduct(Product productRecieve) {
        Product productCreated = product_Repository.save(productRecieve);
        return productCreated;
    }
}
