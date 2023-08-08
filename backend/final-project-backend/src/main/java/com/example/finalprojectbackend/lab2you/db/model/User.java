package com.example.finalprojectbackend.lab2you.db.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    public static final List<User> users = new ArrayList<>();

    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private List<Role> roles;

    public User() {
        roles = new ArrayList<>();
    }

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
