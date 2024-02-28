package com.application.todoapp.controllers;

import com.application.todoapp.models.TaskDTO;
import com.application.todoapp.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    private final String TASK_PATH = "/api/v1/tasks";

    private final String TASK_ID = TASK_PATH + "/{taskId}";

    @PostMapping(TASK_PATH)
    public ResponseEntity addNewTask(@Validated @RequestBody TaskDTO taskDTO) {
        taskService.createNewTask(taskDTO);
        HttpHeaders http = new HttpHeaders();
        return new ResponseEntity<>(http, HttpStatus.CREATED);
    }

    @GetMapping(TASK_ID)
    public Optional<TaskDTO> getTaskById(@PathVariable UUID taskId) {
        return taskService.getTaskById(taskId);
    }
}
