package com.application.todoapp.services;

import com.application.todoapp.mappers.UserMapper;
import com.application.todoapp.models.UserDTO;
import com.application.todoapp.repositories.RoleRepository;
import com.application.todoapp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserServiceJPA implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public List<UserDTO> getAllUser() {
         return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        roleRepository.findById(userDTO.getRoleId()).ifPresentOrElse(userDTO::setRole,
                ()->{
                    try {
                        throw new ChangeSetPersister.NotFoundException();
                    } catch (ChangeSetPersister.NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
        return userMapper.userEntityToUserDto(userRepository.save(userMapper.userDtoToUserEntity(userDTO)));
    }

    @Override
    public Optional<UserDTO> getUserById(UUID userId) {

        return Optional.empty();
    }
}
