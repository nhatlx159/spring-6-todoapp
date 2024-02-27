package com.application.todoapp.mappers;

import com.application.todoapp.entities.TaskEntity;
import com.application.todoapp.models.TaskDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskEntity taskDtoToTaskEntity(TaskDTO taskDTO);
    TaskDTO taskEntityToTaskDto(TaskEntity taskEntity);
}
