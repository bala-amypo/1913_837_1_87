package com.example.demo.service.Impl;

import com.example.demo.model.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository categoryRepository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new RuntimeException("Category name must be unique");
        }
        return categoryRepository.save(category);
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}
