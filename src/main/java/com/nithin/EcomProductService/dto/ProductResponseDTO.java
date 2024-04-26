package com.nithin.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class ProductResponseDTO {
    private UUID productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private String productImageURL;
    private double productRating;
    private int quantity;

}
