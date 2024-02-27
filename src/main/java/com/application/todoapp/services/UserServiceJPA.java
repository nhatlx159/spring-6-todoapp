package com.application.todoapp.services;

import com.application.todoapp.mappers.UserMapper;
import com.application.todoapp.models.UserDTO;
import com.application.todoapp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceJPA implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
         return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.userEntityToUserDto(userRepository.save(userMapper.userDtoToUserEntity(userDTO)));
    }

    @Override
    public Optional<UserDTO> getUserById(UUID userId) {

        return Optional.empty();
    }
}
