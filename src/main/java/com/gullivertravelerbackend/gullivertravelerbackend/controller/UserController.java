package com.gullivertravelerbackend.gullivertravelerbackend.controller;


import java.util.List;

import com.gullivertravelerbackend.gullivertravelerbackend.dto.UserRequestDTO;
import com.gullivertravelerbackend.gullivertravelerbackend.dto.UserResponseDTO;
import com.gullivertravelerbackend.gullivertravelerbackend.entity.User;
import com.gullivertravelerbackend.gullivertravelerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createUser(@RequestBody UserRequestDTO user) {
        User users = new User(user);
        userRepository.save(users);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        List<UserResponseDTO> users = userRepository.findAll().stream().map(UserResponseDTO::new).toList();
        return users;
    }


}

