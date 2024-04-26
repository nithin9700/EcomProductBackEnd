package com.nithin.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private String productImageURL;
    private int quantity;

}
