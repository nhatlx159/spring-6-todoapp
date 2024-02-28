package com.application.todoapp.controllers;

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

    private final String USER_ID = USER_PATH + "/{userId}";

    @GetMapping(USER_PATH)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping(USER_ID)
    public Optional<UserDTO> getUserById(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(USER_PATH)
    public ResponseEntity addNewUser(@Validated @RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }
}
