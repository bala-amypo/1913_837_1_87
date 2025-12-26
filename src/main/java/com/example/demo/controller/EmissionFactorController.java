package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @PostMapping("/type/{activityTypeId}")
    public ResponseEntity<?> createFactor(@PathVariable Long activityTypeId, @RequestBody EmissionFactor factor) {
        return ResponseEntity.ok(factorService.createFactor(activityTypeId, factor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFactor(@PathVariable Long id) {
        return ResponseEntity.ok(factorService.getFactor(id));
    }

    @GetMapping("/type/{activityTypeId}")
    public ResponseEntity<?> getFactorByType(@PathVariable Long activityTypeId) {
        return ResponseEntity.ok(factorService.getFactorByType(activityTypeId));
    }

    @GetMapping
    public ResponseEntity<?> getAllFactors() {
        return ResponseEntity.ok(factorService.getAllFactors());
    }
}
