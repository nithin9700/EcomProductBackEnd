package com.nithin.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryCreateResponseDTO {
    private UUID id;
    private String name;
    private String description;
}
