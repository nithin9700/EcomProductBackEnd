package com.nithin.EcomProductService.controller;


import com.nithin.EcomProductService.dto.CategoryCreateRequestDTO;
import com.nithin.EcomProductService.dto.CategoryCreateResponseDTO;
import com.nithin.EcomProductService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryCreateResponseDTO> createCategory(@RequestBody CategoryCreateRequestDTO categoryCreateRequestDTO) {
        CategoryCreateResponseDTO categoryCreateResponseDTO =  categoryService.createCategory(categoryCreateRequestDTO);
        return ResponseEntity.ok(categoryCreateResponseDTO);
    }
}
