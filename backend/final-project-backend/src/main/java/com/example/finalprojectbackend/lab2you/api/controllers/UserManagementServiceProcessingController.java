package com.example.finalprojectbackend.lab2you.api.controllers;

import com.example.finalprojectbackend.lab2you.db.model.UserEntity;
import com.example.finalprojectbackend.lab2you.db.model.UserWrapper;
import com.example.finalprojectbackend.lab2you.service.EmailService;
import com.example.finalprojectbackend.lab2you.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserManagementServiceProcessingController {
    private final EmailService emailService;
    private final UserService userService;

    @Autowired
    public UserManagementServiceProcessingController(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity userEntity) {
        try {
            emailService.sendRegistrationEmail(userEntity);
            return ResponseEntity.ok("Lab2YouConstants.lab2YouSuccessCodes.EMAIL_SENT.getMessage()");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lab2YouConstants.EMAIL_NOT_SENT.getMessage()");
        }
    }

    @GetMapping("/userList")
    public ResponseEntity<List<UserWrapper>> getUsers() {
        return new ResponseEntity<>(userService.executedReadAll(), HttpStatus.OK);
    }

}
