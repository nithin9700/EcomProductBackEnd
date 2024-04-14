package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Qualifier
public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO  getProduct(int productId);
    FakeStoreProductResponseDTO  createProduct(Product product);
    FakeStoreProductResponseDTO  updateProduct(Product product, int productId);
    boolean deleteProduct(int productId);



}
