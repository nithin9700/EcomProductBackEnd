package com.nithin.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String productName;
    private String productDescription;
    private double productPrice;
    @ManyToOne
    private Category productCategory;
    private String productImageURL;
    private double productRating;
    private int quantity;
}
