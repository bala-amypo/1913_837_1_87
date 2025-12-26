package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepository, ActivityCategoryRepository categoryRepository) {
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityType createType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        
        if (type.getUnit() == null || type.getUnit().isBlank()) {
            throw new ValidationException("Unit is required");
        }

        type.setCategory(category);
        return typeRepository.save(type);
    }

    @Override
    public ActivityType getType(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity Type not found"));
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        // Also ensure category exists? Spec doesn't strictly say but good practice.
        // However, repo method just returns list. t43 calls repo directly.
        // I'll check category existence just in case, but standard find is fine.
        if (!categoryRepository.existsById(categoryId)) {
             throw new ResourceNotFoundException("Category not found");
        }
        return typeRepository.findByCategory_Id(categoryId);
    }
}
