package com.example.finalprojectbackend.lab2you.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private Long cui;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private String Nit;
    private String address;
    private String phoneNumber;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_cui", referencedColumnName = "cui"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

}
