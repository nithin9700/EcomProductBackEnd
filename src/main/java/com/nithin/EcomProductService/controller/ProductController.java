package com.nithin.EcomProductService.controller;


import com.nithin.EcomProductService.dto.ProductCreateDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.InvalidInputException;
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
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id){
        if(id  == null){
            throw new InvalidInputException("Input is not correct");
        }

        return ResponseEntity.ok(productService.getProduct(id));
    }
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductCreateDTO ProductCreateDTO){
        if(ProductCreateDTO == null){
            throw new ProductNotFoundException("Product not found");
        }
        ProductResponseDTO productResponseDTO = productService.createProduct(ProductCreateDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product){
        if(id == null){
            throw new InvalidInputException("Input is not correct");
        }
        if(product == null){
             throw new ProductNotFoundException("Product not found");
        }
        //Product product1 = productService.updateProduct(product, id);
        return  null; //ResponseEntity.ok(product1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}