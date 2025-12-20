package com.example.demo.service.Impl;

import com.example.demo.model.ActivityType;
import com.example.demo.model.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository factorRepository;
    private final ActivityTypeRepository typeRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository factorRepository,
                                     ActivityTypeRepository typeRepository) {
        this.factorRepository = factorRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor) {
        ActivityType type = typeRepository.findById(activityTypeId)
                .orElseThrow(() -> new RuntimeException("Activity type not found"));
        factor.setActivityType(type);
        return factorRepository.save(factor);
    }

    @Override
    public EmissionFactor getFactor(Long id) {
        return factorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emission factor not found"));
    }

    @Override
    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepository.findByActivityType_Id(typeId)
                .orElseThrow(() -> new RuntimeException("Emission factor not found"));
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}
