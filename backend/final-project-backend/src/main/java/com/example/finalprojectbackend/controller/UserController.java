package com.example.finalprojectbackend.controller;
import com.example.finalprojectbackend.model.User;
import com.example.finalprojectbackend.service.EmailService;
import com.example.finalprojectbackend.util.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final EmailService emailService;

    @Autowired
    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
//            validation first before send the email
            emailService.sendRegistrationEmail(user);
            return ResponseEntity.ok(ErrorMessage.EMAIL_SENT.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ErrorMessage.EMAIL_NOT_SENT.getMessage());
        }
    }

    @GetMapping("/userList")
    public ResponseEntity<List<User>> userList(){
        try {
            return ResponseEntity.ok(User.users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
