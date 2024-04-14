package com.nithin.EcomProductService.controller;


import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;

import com.nithin.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService; // field injection


    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOS = productService.getAllProducts();
        return ResponseEntity.ok(fakeStoreProductResponseDTOS);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOS = productService.getAllProducts();

        return ResponseEntity.ok(fakeStoreProductResponseDTOS);
    }

}
