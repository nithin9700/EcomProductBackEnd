package com.nithin.EcomProductService.mapper;

import com.nithin.EcomProductService.dto.ProductRequestDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO productToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductDescription(product.getProductDescription());
        productResponseDTO.setProductPrice(product.getProductPrice());
        productResponseDTO.setProductImageURL(product.getProductImageURL());
        productResponseDTO.setProductRating(product.getProductRating());
        productResponseDTO.setProductCategory(product.getProductCategory().getName());
        productResponseDTO.setQuantity(product.getQuantity());

        return productResponseDTO;
    }
    public static Product productResponseDTOToProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductImageURL(productRequestDTO.getProductImageURL());
        product.setProductRating(0);
        product.setQuantity(productRequestDTO.getQuantity());
        product.setProductCategory(product.getProductCategory());
        return product;
    }
}
/*

product
    private String productName;
    private String productDescription;
    private double productPrice;
    @ManyToOne
    private Category productCategory;
    private String productImageURL;
    private double productRating;
    private int quantity;


// productresponse dto
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private String productImageURL;
    private double productRating;
 */