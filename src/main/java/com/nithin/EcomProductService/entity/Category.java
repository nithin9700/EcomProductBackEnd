package com.nithin.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Category extends BaseModel{
    private String name;
    private String description;
    @OneToMany
    private List<Product> products;

}
