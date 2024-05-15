package com.nithin.EcomProductService.controller;


import com.nithin.EcomProductService.client.UserTokenAuthentication;
import com.nithin.EcomProductService.dto.ProductRequestDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.AuthenticationException;
import com.nithin.EcomProductService.exception.InvalidInputException;
import com.nithin.EcomProductService.exception.ProductNotFoundException;
import com.nithin.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private UserTokenAuthentication userTokenAuthentication;
    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(@RequestHeader("Authorization") String token){

        List<ProductResponseDTO> products = productService.getAllProducts(token);
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
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO ProductRequestDTO){
        if(ProductRequestDTO == null){
            throw new ProductNotFoundException("Product not found");
        }
        ProductResponseDTO productResponseDTO = productService.createProduct(ProductRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDTO productRequestDTO){
        if(id == null){
            throw new InvalidInputException("Input is not correct");
        }
        if(productRequestDTO == null){
             throw new ProductNotFoundException("Product not found");
        }
        ProductResponseDTO productResponseDTO = productService.updateProduct(productRequestDTO, id);
        return  ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PostMapping("/list")
    public ResponseEntity<List<ProductResponseDTO>> createProductList(@RequestBody List<ProductRequestDTO> productRequestDTO){
        List<ProductResponseDTO> products = new ArrayList<>();
        for(ProductRequestDTO productRequestDTO1 : productRequestDTO){
            products.add(productService.createProduct(productRequestDTO1));
        }
        return ResponseEntity.ok(products);
    }


}