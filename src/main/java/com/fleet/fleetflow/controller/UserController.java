package com.fleet.fleetflow.controller;

import com.fleet.fleetflow.dto.UserDto;
import com.fleet.fleetflow.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get user Details")
    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<UserDto> generateToken() {
        UserDto userDto = userService.getUserDetails();
        return ResponseEntity.ok(userDto);
    }

}
