package com.gullivertravelerbackend.gullivertravelerbackend.dto;

import com.gullivertravelerbackend.gullivertravelerbackend.entity.User;

public record UserResponseDTO(Integer id, String name, String photo) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getPhoto());
    }
}
