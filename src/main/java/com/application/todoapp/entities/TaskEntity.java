package com.application.todoapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @NotNull
    @NotBlank
    private String taskName;

    @NotNull
    @NotBlank
    private String taskDescription;

    @NotNull
    @NotBlank
    private LocalDateTime atTime;

    @NotNull
    @NotBlank
    private boolean completed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ToString.Exclude
    private UserEntity user;
}
