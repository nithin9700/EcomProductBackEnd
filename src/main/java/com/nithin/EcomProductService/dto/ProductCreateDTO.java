package com.nithin.EcomProductService.dto;

import com.nithin.EcomProductService.entity.Category;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductCreateDTO {
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productCategory;
    private String productImageURL;
    private int quantity;

}
