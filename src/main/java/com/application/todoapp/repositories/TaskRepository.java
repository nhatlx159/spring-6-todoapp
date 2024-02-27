package com.application.todoapp.repositories;

import com.application.todoapp.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}
