package com.application.todoapp.mappers;

import com.application.todoapp.entities.RoleEntity;
import com.application.todoapp.models.RoleDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleEntity roleDtoToRoleEntity(RoleDTO roleDTO);
    RoleDTO roleEntityToRoleDto(RoleEntity roleEntity);
}
