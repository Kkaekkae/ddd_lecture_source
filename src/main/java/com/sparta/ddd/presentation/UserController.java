package com.sparta.ddd.presentation;

import com.sparta.ddd.application.dtos.user.UserResponse;
import com.sparta.ddd.application.service.UserService;
import com.sparta.ddd.presentation.dtos.SimpleUpdateUserRequest;
import com.sparta.ddd.presentation.dtos.UpdateUserRequest;
import com.sparta.ddd.presentation.dtos.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request.toDTO()));
    }

    @PutMapping("/simple/{userId}")
    public ResponseEntity<UserResponse> simpleUpdateUser(
            @RequestBody SimpleUpdateUserRequest request,
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.simpleUpdateUser(userId, request.toDTO()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @RequestBody UpdateUserRequest request,
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.updateUser(userId, request.toDTO()));
    }
}
