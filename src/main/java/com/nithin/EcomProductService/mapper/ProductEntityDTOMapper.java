package com.nithin.EcomProductService.mapper;

import com.nithin.EcomProductService.dto.ProductCreateDTO;
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

        return productResponseDTO;
    }
    public static Product productResponseDTOToProduct(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setProductName(productCreateDTO.getProductName());
        product.setProductDescription(productCreateDTO.getProductDescription());
        product.setProductPrice(productCreateDTO.getProductPrice());
        product.setProductImageURL(productCreateDTO.getProductImageURL());
        product.setProductRating(0);
        product.setQuantity(productCreateDTO.getQuantity());
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