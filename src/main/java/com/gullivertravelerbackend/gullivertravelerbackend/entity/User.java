package com.gullivertravelerbackend.gullivertravelerbackend.entity;

import com.gullivertravelerbackend.gullivertravelerbackend.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//import java.time.LocalDate;

@Table(name = "user")
@Entity(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String photo;

    public User(UserRequestDTO user){
        this.name = user.name();
        this.photo = user.photo();
    }
}
