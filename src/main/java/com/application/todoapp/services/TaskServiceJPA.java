package com.application.todoapp.services;

import com.application.todoapp.mappers.TaskMapper;
import com.application.todoapp.mappers.UserMapper;
import com.application.todoapp.models.TaskDTO;
import com.application.todoapp.repositories.TaskRepository;
import com.application.todoapp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceJPA implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<TaskDTO> getTaskById(UUID id) {
        TaskDTO existingTask = taskMapper.taskEntityToTaskDto(taskRepository.findById(id).orElse(null));
        return Optional.of(existingTask);
    }

    @Override
    public TaskDTO createNewTask(TaskDTO taskDTO) {
        taskDTO.setUser(userRepository.findById(taskDTO.getUserId()).orElse(null));
        return taskMapper.taskEntityToTaskDto(taskRepository.save(taskMapper.taskDtoToTaskEntity(taskDTO)));
    }
}
