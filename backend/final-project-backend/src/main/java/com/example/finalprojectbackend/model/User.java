package com.example.finalprojectbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class User {
    public static final List<User> users = new ArrayList<>();

    public User(String name, String lastName, String email, String role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String role;
}
