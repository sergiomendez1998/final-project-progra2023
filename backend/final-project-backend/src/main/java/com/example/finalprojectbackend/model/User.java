package com.example.finalprojectbackend.model;

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
    private String role;
}
