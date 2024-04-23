package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(UUID productId);
    Product  createProduct(Product product);
    Product  updateProduct(Product product, UUID productId);
    boolean deleteProduct(UUID productId);
    Product getProductByName(String productName);
    List<Product> getProductsByRange(double min, double max);
}
