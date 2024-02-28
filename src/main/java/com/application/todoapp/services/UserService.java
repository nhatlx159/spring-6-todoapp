package com.application.todoapp.services;

import com.application.todoapp.models.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAllUser();

    UserDTO createUser(UserDTO userDTO);

    Optional<UserDTO> getUserById(UUID userId);
}
