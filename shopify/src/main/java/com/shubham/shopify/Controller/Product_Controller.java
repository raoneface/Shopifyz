package com.shubham.shopify.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.shopify.Entity.Product;
import com.shubham.shopify.Service.Product_Service;

@RestController
@RequestMapping("Shopify/api/product")
public class Product_Controller {
     Product_Service product_service;

    public Product_Controller(Product_Service product_service) {
        this.product_service = product_service;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Product>  addProduct(@RequestBody Product productReq){
       Product createdproduct = product_service.addProduct(productReq);
       return  ResponseEntity.status(HttpStatus.CREATED).body(createdproduct);
    }
}
