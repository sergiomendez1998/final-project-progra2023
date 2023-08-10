package com.example.finalprojectbackend.lab2you.db.model.dto;

import com.example.finalprojectbackend.lab2you.db.model.wrappers.UserWrapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends UserWrapper {
    private String password;
}
