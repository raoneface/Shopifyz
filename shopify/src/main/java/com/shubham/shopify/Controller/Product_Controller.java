package com.shubham.shopify.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.shopify.Dto.Product_RequestDto;
import com.shubham.shopify.Dto.Product_ResponseDto;
import com.shubham.shopify.Service.Product_Service;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Shopify/api/product")
public class Product_Controller {
    Product_Service product_service;

    public Product_Controller(Product_Service product_service) {
        this.product_service = product_service;
    }

    @PostMapping
    public ResponseEntity<Product_ResponseDto>  addProduct(@Valid @RequestBody Product_RequestDto product_Req_Dto){
       Product_ResponseDto createdproduct = product_service.addProduct(product_Req_Dto);
       return  ResponseEntity.status(HttpStatus.CREATED).body(createdproduct);
    }
}
