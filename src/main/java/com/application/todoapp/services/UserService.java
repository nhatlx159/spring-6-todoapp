package com.application.todoapp.services;

import com.application.todoapp.models.ResponseUserDTO;
import com.application.todoapp.models.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<ResponseUserDTO> getAllUser();

    ResponseUserDTO createUser(UserDTO userDTO);

    Optional<ResponseUserDTO> getUserById(UUID userId);

    Optional<ResponseUserDTO> loginUser(UserDTO userDTO);
}
