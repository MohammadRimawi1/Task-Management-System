package com.managment.managementsystem.controllers;

import com.managment.managementsystem.models.Category;
import com.managment.managementsystem.services.CategoryServices;
import jakarta.validation.Valid;
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
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryServices.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryServices.getAllCategories();
    }
}
