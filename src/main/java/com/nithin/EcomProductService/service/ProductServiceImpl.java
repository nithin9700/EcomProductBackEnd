package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.ProductRequestDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Category;
import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.CategoryNotFoundException;
import com.nithin.EcomProductService.exception.ProductNotFoundException;
import com.nithin.EcomProductService.mapper.ProductEntityDTOMapper;
import com.nithin.EcomProductService.repositories.CategoryRepository;
import com.nithin.EcomProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for (Product product : products)
            productResponseDTOs.add(ProductEntityDTOMapper.productToProductResponseDTO(product));
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product with id " + productId + " not found")
        );
        return ProductEntityDTOMapper.productToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.productResponseDTOToProduct(productRequestDTO);
        Category category = categoryRepository.findByName(productRequestDTO.getProductCategory());
        if(category == null) {
            throw new CategoryNotFoundException("Category with name " + productRequestDTO.getProductCategory() + " not found");
        }
        product.setProductCategory(category);
        Product savedProduct = productRepository.save(product);
        return ProductEntityDTOMapper.productToProductResponseDTO(savedProduct);
    }
    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, UUID productId) {
        Product updateProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product with id " + productId + " not found")
        );
        Product product = ProductEntityDTOMapper.productResponseDTOToProduct(productRequestDTO);
        Category category = categoryRepository.findByName(productRequestDTO.getProductCategory());
        if(category == null) {
            throw new CategoryNotFoundException("Category with name " + productRequestDTO.getProductCategory() + " not found");
        }
        product.setProductCategory(category);
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setProductPrice(product.getProductPrice());
        updateProduct.setProductImageURL(product.getProductImageURL());
        updateProduct.setProductRating(product.getProductRating());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setProductCategory(product.getProductCategory());
        Product savedProduct = productRepository.save(updateProduct);
        return ProductEntityDTOMapper.productToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProductByName(String productName) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getProductsByRange(double min, double max) {
        //return productRepository.findProductBetweenMinAndMax(min, max);
        return null;
    }
}
