package com.nithin.EcomProductService.mapper;


import com.nithin.EcomProductService.dto.CategoryCreateRequestDTO;
import com.nithin.EcomProductService.dto.CategoryCreateResponseDTO;
import com.nithin.EcomProductService.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryEntityDTOMapper {

    public static Category CategoryEntityToCategoryDTO(CategoryCreateRequestDTO categoryCreateRequestDTO) {
        Category category = new Category();
        category.setDescription(categoryCreateRequestDTO.getDescription());
        category.setName(categoryCreateRequestDTO.getName());
        return category;
    }

    public static CategoryCreateResponseDTO CategoryToCategoryEntityDTO(Category category) {
        CategoryCreateResponseDTO categoryCreateResponseDTO = new CategoryCreateResponseDTO();
        categoryCreateResponseDTO.setDescription(category.getDescription());
        categoryCreateResponseDTO.setId(category.getId());
        categoryCreateResponseDTO.setName(category.getName());
        return categoryCreateResponseDTO;
    }
}
