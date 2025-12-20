package com.example.demo.service.Impl;

import com.example.demo.model.ActivityCategory;
import com.example.demo.model.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepository,
                                   ActivityCategoryRepository categoryRepository) {
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityType createType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        type.setCategory(category);
        return typeRepository.save(type);
    }

    @Override
    public ActivityType getType(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity type not found"));
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategory_Id(categoryId);
    }
}
