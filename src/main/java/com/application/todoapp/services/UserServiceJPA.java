package com.application.todoapp.services;

import com.application.todoapp.mappers.UserMapper;
import com.application.todoapp.models.ResponseUserDTO;
import com.application.todoapp.models.UserDTO;
import com.application.todoapp.repositories.RoleRepository;
import com.application.todoapp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.*;
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
    public List<ResponseUserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToResponseUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseUserDTO createUser(UserDTO userDTO) {
        if (userDTO.getRoleId() == null) {
            userDTO.setRoleId(1);
        }
        roleRepository.findById(userDTO.getRoleId()).ifPresentOrElse(userDTO::setRole,
                () -> {
                    try {
                        throw new ChangeSetPersister.NotFoundException();
                    } catch (ChangeSetPersister.NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
        // Hash password
        String password = userDTO.getPassword();
        byte[] salt = generateSalt();

        // Generate hashed password
        String hashedPassword = hashPassword(password, salt);
        userDTO.setPassword(hashedPassword);
        userDTO.setSalt(salt);
        ResponseUserDTO responseUserDTO = userMapper.userEntityToResponseUserDTO(userRepository.save(userMapper.userDtoToUserEntity(userDTO)));
        responseUserDTO.setRoleId(userDTO.getRoleId());
        responseUserDTO.setTasks(userDTO.getTasks());
        return responseUserDTO;
    }
    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    private String hashPassword(String password, byte[] salt) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private boolean validatePassword(String inputPassword, byte[] salt, String hashedPassword) {
        String newlyHashedPassword = hashPassword(inputPassword, salt);
        return hashedPassword.equals(newlyHashedPassword);
    }
    @Override
    public Optional<ResponseUserDTO> getUserById(UUID userId) {
        UserDTO existingUser = userMapper.userEntityToUserDto(userRepository.findById(userId).orElse(null));
        existingUser.setRoleId(existingUser.getRole().getId());
        return Optional.of(userMapper.userDtoToResponseUserDto(existingUser));
    }

    @Override
    public Optional<ResponseUserDTO> loginUser(UserDTO userDTO) {
        UserDTO existingUser = userMapper.userEntityToUserDto(userRepository.findByEmail(userDTO.getEmail()).orElse(null));
        if (existingUser == null) {
            return Optional.empty();
        }
        if (validatePassword(userDTO.getPassword(), existingUser.getSalt(), existingUser.getPassword())) {
            ResponseUserDTO user = userMapper.userEntityToResponseUserDTO(userMapper.userDtoToUserEntity(existingUser));
            user.setRoleId(existingUser.getRole().getId());
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
