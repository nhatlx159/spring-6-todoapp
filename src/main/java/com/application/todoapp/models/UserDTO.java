package com.application.todoapp.models;

import com.application.todoapp.entities.RoleEntity;
import com.application.todoapp.entities.TaskEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class UserDTO {
    private UUID id;

    private Integer version;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String phone;

    private LocalDateTime isDelete;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<TaskEntity> tasks;

    private RoleEntity role;

    private Integer roleId;
}
