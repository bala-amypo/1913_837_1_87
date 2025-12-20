package com.example.demo.repository;

import com.example.demo.model.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {

    boolean existsByCategoryName(String categoryName);
}
