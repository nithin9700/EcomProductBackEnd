package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.CategoryCreateRequestDTO;
import com.nithin.EcomProductService.dto.CategoryCreateResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryCreateResponseDTO createCategory(CategoryCreateRequestDTO categoryCreateRequestDTO);
    List<CategoryCreateResponseDTO> getAllCategories(String token);
}
