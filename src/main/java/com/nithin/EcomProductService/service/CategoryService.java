package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.CategoryCreateRequestDTO;
import com.nithin.EcomProductService.dto.CategoryCreateResponseDTO;

public interface CategoryService {
    CategoryCreateResponseDTO createCategory(CategoryCreateRequestDTO categoryCreateRequestDTO);
}
