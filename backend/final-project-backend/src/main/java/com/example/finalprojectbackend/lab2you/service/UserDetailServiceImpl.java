package com.example.finalprojectbackend.lab2you.service;

import com.example.finalprojectbackend.lab2you.config.security.UserDetailsImpl;
import com.example.finalprojectbackend.lab2you.db.model.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserDetailServiceImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    /*
    * This method is used to load the user by username.
    * It is used by the authentication manager to validate the user if exists in the record.
    *
    */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserDetailsImpl(userEntity);
    }
}
