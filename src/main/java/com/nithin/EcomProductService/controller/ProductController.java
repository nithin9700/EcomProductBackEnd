package com.nithin.EcomProductService.controller;


import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;

import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.InvalidInputException;
import com.nithin.EcomProductService.exception.NoProductFoundException;
import com.nithin.EcomProductService.exception.ProductNotFoundException;
import com.nithin.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        if(id < 1){
            throw new InvalidInputException("Input is not correct");
        }
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/productexception")
    public ResponseEntity getProductException(){
        //throw new RandomException("Exception from product");
        throw new ProductNotFoundException("Product not found");
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product){
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
}