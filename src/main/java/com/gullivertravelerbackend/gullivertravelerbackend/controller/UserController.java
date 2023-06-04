package com.gullivertravelerbackend.gullivertravelerbackend.controller;

import com.gullivertravelerbackend.gullivertravelerbackend.entity.User;
import com.gullivertravelerbackend.gullivertravelerbackend.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Api(tags = "User")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ApiOperation("Criar um novo usuario")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ApiOperation("Pega todos os usuarios cadastrados")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ApiOperation("Pega usuario cadastrado por ID")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @ApiOperation("Atualiza usuario cadastrado por ID")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @ApiOperation("Deleta usuario cadastrado por ID")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
