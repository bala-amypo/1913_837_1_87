package com.example.demo.service;

import com.example.demo.model.ActivityCategory;

import java.util.List;

public interface ActivityCategoryService {

    ActivityCategory createCategory(ActivityCategory category);

    ActivityCategory getCategory(Long id);

    List<ActivityCategory> getAllCategories();
}
