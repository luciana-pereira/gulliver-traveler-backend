package com.gullivertravelerbackend.gullivertravelerbackend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "user")
@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String photo;
    private String gender;
    private String email;
    private String password;
    private LocalDate birth;
    private LocalDate last_access;
    private String city;
    private String state;
    private String country;
    private String address;
    private int number;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto() {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getLast_access() {
        return last_access;
    }

    public void setLast_access(LocalDate last_access) {
        this.last_access = last_access;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}