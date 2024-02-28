package com.application.todoapp.models;

import com.application.todoapp.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class TaskDTO {
    private UUID id;

    private Integer version;

    @NotNull
    @NotBlank
    private String taskName;

    @NotNull
    @NotBlank
    private String taskDescription;

    @NotNull
    private LocalDateTime atTime;

    private boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UserEntity user;

    @NotNull
    private UUID userId;
}
