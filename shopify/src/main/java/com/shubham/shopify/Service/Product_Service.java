package com.shubham.shopify.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.shubham.shopify.Dto.Product_RequestDto;
import com.shubham.shopify.Dto.Product_ResponseDto;
import com.shubham.shopify.Entity.Product;
import com.shubham.shopify.Repository.Product_Repository;

@Service
public class Product_Service {
    Product_Repository product_Repository;

    public Product_Service(Product_Repository product_Repository) {
        this.product_Repository = product_Repository;
    }

    public Product_ResponseDto addProduct(Product_RequestDto product_Req_Dto) {
        Product product_Req = mapToEntity(product_Req_Dto);
        Product product_Res = product_Repository.save(product_Req);
        return mapToResponseDto(product_Res);
    }

    private Product mapToEntity(Product_RequestDto product_RequestDto) {
        Product product = new Product();
        product.setProduct_name(product_RequestDto.getProduct_name());
        product.setPrice(product_RequestDto.getPrice());
        product.setCategory(product_RequestDto.getCategory());
        product.setDescription(product_RequestDto.getDescription());
        product.setCreated_time(LocalDateTime.now());
        product.setUpdated_time(LocalDateTime.now());
        return product;
    }

    private Product_ResponseDto mapToResponseDto(Product product) {
        Product_ResponseDto product_Response_Dto = new Product_ResponseDto();
        product_Response_Dto.setId(product.getId());
        product_Response_Dto.setProduct_name(product.getProduct_name());
        product_Response_Dto.setPrice(product.getPrice());
        product_Response_Dto.setCategory(product.getCategory());
        product_Response_Dto.setDescription(product.getDescription());
        product_Response_Dto.setCreated_time(product.getCreated_time());
        product_Response_Dto.setUpdated_time(product.getUpdated_time());
        return product_Response_Dto;
    }
}
