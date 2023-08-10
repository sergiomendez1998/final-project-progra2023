package com.example.finalprojectbackend.lab2you.db.model.wrappers;

import com.example.finalprojectbackend.lab2you.db.model.entities.Role;
import com.example.finalprojectbackend.lab2you.db.model.entities.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserWrapper {
    private Long cui;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String nit;
    private String phoneNumber;
    private List<Role> roles;

    public UserWrapper(UserEntity userEntity, List<Role> roles) {
        this.cui = userEntity.getCui();
        this.name = userEntity.getName();
        this.lastName = userEntity.getLastName();
        this.address = userEntity.getAddress();
        this.email = userEntity.getEmail();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.roles = roles;
    }
}
