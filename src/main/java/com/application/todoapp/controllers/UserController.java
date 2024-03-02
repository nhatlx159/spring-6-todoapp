package com.application.todoapp.controllers;

import com.application.todoapp.models.ResponseUserDTO;
import com.application.todoapp.models.UserDTO;
import com.application.todoapp.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final String USER_PATH = "/api/v1/users";

    private final String USER_REGISTER = USER_PATH + "/register";

    private final String USER_LOGIN = USER_PATH + "/login";

    private final String USER_ID = USER_PATH + "/{userId}";

    @GetMapping(USER_PATH)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping(USER_ID)
    public Optional<ResponseUserDTO> getUserById(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(USER_REGISTER)
    public ResponseEntity<UserDTO> userRegister(@Validated @RequestBody UserDTO userDTO) {
        UserDTO user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(USER_LOGIN)
    public ResponseEntity<Optional<ResponseUserDTO>> userLogin(@Validated @RequestBody UserDTO userDTO) {
        Optional<ResponseUserDTO> result = userService.loginUser(userDTO);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(userService.loginUser(userDTO));
    }
}
