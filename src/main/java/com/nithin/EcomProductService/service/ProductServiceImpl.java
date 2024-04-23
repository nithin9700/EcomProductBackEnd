package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.ProductNotFoundException;
import com.nithin.EcomProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product with id " + productId + " not found")
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product product1 = productRepository.save(product);
        return product1;
    }
    @Override
    public Product updateProduct(Product product, UUID productId) {
        Product updateProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product with id " + productId + " not found")
        );
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setProductPrice(product.getProductPrice());
        updateProduct.setProductImageURL(product.getProductImageURL());
        updateProduct.setProductRating(product.getProductRating());
        updateProduct.setQuantity(product.getQuantity());
        return productRepository.save(updateProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getProductsByRange(double min, double max) {
        //return productRepository.findProductBetweenMinAndMax(min, max);
        return null;
    }
}
