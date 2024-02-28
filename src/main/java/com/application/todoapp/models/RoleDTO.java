package com.application.todoapp.models;

import com.application.todoapp.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class RoleDTO {
    private Integer id;

    @NotNull
    @NotBlank
    private String roleName;

    @NotNull
    @NotBlank
    private String roleDescription;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<UserEntity> users;
}
