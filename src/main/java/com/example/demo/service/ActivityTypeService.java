package com.example.demo.service;

import com.example.demo.model.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType createType(Long categoryId, ActivityType type);

    ActivityType getType(Long id);

    List<ActivityType> getTypesByCategory(Long categoryId);
}
