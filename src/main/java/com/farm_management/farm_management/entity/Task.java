package com.farm_management.farm_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id", referencedColumnName = "user_id")
    private User assignedUser;

    @ManyToOne
    @JoinColumn(name = "assigned_team_id", referencedColumnName = "team_id", nullable = true)
    private Team assignedTeam; // Optional field, assuming you have a Team entity

    @Column(name = "priority", length = 10)
    private String priority; // High, Medium, Low

    @Column(name = "task_category")
    private String Taskcategory;

    @Column(name = "status", length = 20)
    private String status; // Todo, In Progress, Completed, On Hold, Canceled

    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "completion_date")
    @Temporal(TemporalType.DATE)
    private Date completionDate;

    @Column(name = "comments", columnDefinition = "TEXT", nullable = true)
    private String comments;

    @Column(name = "attachments", length = 255, nullable = true)
    private String attachments;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}