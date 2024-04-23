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
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id){
        if(id  == null){
            throw new InvalidInputException("Input is not correct");
        }
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        if(product == null){
            throw new ProductNotFoundException("Product not found");
        }
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product){
        if(id == null){
            throw new InvalidInputException("Input is not correct");
        }
        if(product == null){
             throw new ProductNotFoundException("Product not found");
        }
        Product product1 = productService.updateProduct(product, id);
        return  ResponseEntity.ok(product1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}