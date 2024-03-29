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

    private String email;

    private String fullName;

    private String password;

    private String phone;

    private LocalDateTime isDelete;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<TaskEntity> tasks;

    private RoleEntity role;

    private Integer roleId;

    private byte[] salt;
}
