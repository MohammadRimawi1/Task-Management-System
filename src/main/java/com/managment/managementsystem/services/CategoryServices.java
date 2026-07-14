package com.managment.managementsystem.services;

import com.managment.managementsystem.models.Category;
import com.managment.managementsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category doesn't exist " + id));
    }
}
