package com.example.finalprojectbackend.lab2you;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Lab2YouUtils {

    public static String encodePassword(String password) {
        return  new BCryptPasswordEncoder().encode(password);
    }

    public static boolean passwordEncrypted(String password, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(password, encodedPassword);
    }

    public static boolean verifyEmailFormat(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

}
