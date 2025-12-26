// com.example.demo.dto.ActivityLogRequest.java
package com.example.demo.dto;

import java.time.LocalDate;

public record ActivityLogRequest(Double quantity, LocalDate activityDate) {}