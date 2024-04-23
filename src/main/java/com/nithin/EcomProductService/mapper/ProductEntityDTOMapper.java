package com.nithin.EcomProductService.mapper;

import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO productToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductDescription(product.getProductDescription());
        productResponseDTO.setProductPrice(product.getProductPrice());
        productResponseDTO.setProductImageURL(product.getProductImageURL());
        productResponseDTO.setProductRating(product.getProductRating());
        return productResponseDTO;
    }
}
/*
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private String productImageURL;
    private double productRating;
 */