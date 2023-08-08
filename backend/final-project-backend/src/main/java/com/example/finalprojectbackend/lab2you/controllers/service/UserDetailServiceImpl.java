package com.example.finalprojectbackend.lab2you.controllers.service;

import com.example.finalprojectbackend.lab2you.config.security.UserDetailsImpl;
import com.example.finalprojectbackend.lab2you.db.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    /*
    * This method is used to load the user by username.
    * It is used by the authentication manager to validate the user if exists in the record.
    *
    */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = User.users.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
        return new UserDetailsImpl(user);
    }
}
