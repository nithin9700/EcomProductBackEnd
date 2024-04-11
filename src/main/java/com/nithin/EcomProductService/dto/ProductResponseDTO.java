package com.nithin.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ProductResponseDTO {
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private String productImageURL;
    private double productRating;

}
