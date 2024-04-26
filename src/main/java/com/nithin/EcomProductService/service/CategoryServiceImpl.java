package com.nithin.EcomProductService.service;


import com.nithin.EcomProductService.dto.CategoryCreateRequestDTO;
import com.nithin.EcomProductService.dto.CategoryCreateResponseDTO;
import com.nithin.EcomProductService.entity.Category;
import com.nithin.EcomProductService.mapper.CategoryEntityDTOMapper;
import com.nithin.EcomProductService.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryCreateResponseDTO createCategory(CategoryCreateRequestDTO categoryCreateRequestDTO) {
        Category category = CategoryEntityDTOMapper.CategoryEntityToCategoryDTO(categoryCreateRequestDTO);
        return CategoryEntityDTOMapper.CategoryToCategoryEntityDTO(categoryRepository.save(category));
    }

    @Override
    public List<CategoryCreateResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryCreateResponseDTO> categoryCreateResponseDTOS = new ArrayList<>();
        for (Category category:categories){
            categoryCreateResponseDTOS.add(CategoryEntityDTOMapper.CategoryToCategoryEntityDTO(category));
        }
        return categoryCreateResponseDTOS;
    }
}
