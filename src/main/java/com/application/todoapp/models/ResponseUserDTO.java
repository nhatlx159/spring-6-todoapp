package com.application.todoapp.models;

import com.application.todoapp.entities.RoleEntity;
import com.application.todoapp.entities.TaskEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Builder
@Data
public class ResponseUserDTO {
    private UUID id;

    private Integer version;

    private String email;

    private String fullName;

    private String phone;

    private List<TaskEntity> tasks;

    private Integer roleId;
}
