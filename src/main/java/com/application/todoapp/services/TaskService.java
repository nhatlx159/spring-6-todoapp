package com.application.todoapp.services;

import com.application.todoapp.models.TaskDTO;

import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    Optional<TaskDTO> getTaskById(UUID id);
    TaskDTO createNewTask(TaskDTO taskDTO);
}
