package com.nithin.EcomProductService.service;


import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
