package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private LocalDate activityDate;

    private LocalDateTime loggedAt;

    private Double estimatedEmission;

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }

    public LocalDateTime getLoggedAt() { return loggedAt; }

    public Double getEstimatedEmission() { return estimatedEmission; }
    public void setEstimatedEmission(Double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }
}
