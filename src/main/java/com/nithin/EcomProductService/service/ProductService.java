package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.ProductRequestDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;

import java.util.List;
import java.util.UUID;


public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId);
    ProductResponseDTO  createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO  updateProduct(ProductRequestDTO productRequestDTO, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProductByName(String productName);
    List<ProductResponseDTO> getProductsByRange(double min, double max);
}
