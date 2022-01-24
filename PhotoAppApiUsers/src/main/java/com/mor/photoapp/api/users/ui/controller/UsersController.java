package com.mor.photoapp.api.users.ui.controller;

import com.mor.photoapp.api.users.ui.model.UserRequest;
import com.mor.photoapp.api.users.ui.model.UserResponse;
import com.mor.photoapp.api.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    private IUserService iuserService;

    @GetMapping("/status")
    public String status() {
        return "Working on port: "+env.getProperty("local.server.port")
                +", name is: "+env.getProperty("name");
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        UserResponse userResponse = iuserService.getUserById(id);
        return userResponse;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = iuserService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
