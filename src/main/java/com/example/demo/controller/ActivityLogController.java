package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/{userId}/{typeId}")
    public ResponseEntity<?> logActivity(@PathVariable Long userId, @PathVariable Long typeId, @RequestBody ActivityLogRequest request) {
        ActivityLog log = new ActivityLog();
        log.setQuantity(request.getQuantity());
        log.setActivityDate(request.getActivityDate());
        return ResponseEntity.ok(logService.logActivity(userId, typeId, log));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(logService.getLogsByUser(userId));
    }

    @GetMapping("/user/{userId}/range")
    public ResponseEntity<?> getLogsByDateRange(@PathVariable Long userId, @RequestParam LocalDate start, @RequestParam LocalDate end) {
        return ResponseEntity.ok(logService.getLogsByUserAndDate(userId, start, end));
    }
}
