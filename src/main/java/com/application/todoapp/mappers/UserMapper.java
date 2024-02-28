package com.application.todoapp.mappers;

import com.application.todoapp.entities.UserEntity;
import com.application.todoapp.models.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserEntity userDtoToUserEntity(UserDTO userDTO);

    UserDTO userEntityToUserDto(UserEntity userEntity);
}
