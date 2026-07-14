package com.managment.managementsystem.controllers;

import com.managment.managementsystem.dto.ApiResponse;
import com.managment.managementsystem.models.Category;
import com.managment.managementsystem.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(@Valid @RequestBody Category category) {
        Category savedCategory = categoryServices.createCategory(category);
        ApiResponse<Category> response = new ApiResponse<>(true, "Category created successfully", savedCategory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        List<Category> categories = categoryServices.getAllCategories();
        ApiResponse<List<Category>> response = new ApiResponse<>(true, "Categories retrieved successfully", categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}