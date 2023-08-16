package com.example.finalprojectbackend.lab2you.db.model.dto;

import com.example.finalprojectbackend.lab2you.Lab2YouUtils;
import com.example.finalprojectbackend.lab2you.db.model.entities.UserEntity;

public class UserDTOConverter {

    public UserEntity convertToEntity(UserDTO userDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setCui(userDTO.getCui());
        newUser.setName(userDTO.getName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setAddress(userDTO.getAddress());
        newUser.setPhoneNumber(userDTO.getPhoneNumber());
        newUser.setNit(userDTO.getNit());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(Lab2YouUtils.encodePassword(userDTO.getPassword()));
        newUser.setEnabled(true);
        newUser.setGender(userDTO.getGender());
        return newUser;
    }
}
