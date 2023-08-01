package com.example.finalprojectbackend.service;

import com.example.finalprojectbackend.config.security.UserDetailsImpl;
import com.example.finalprojectbackend.model.AuthCredentials;
import com.example.finalprojectbackend.model.User;
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
