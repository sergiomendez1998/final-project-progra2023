package com.example.finalprojectbackend.controller;
import com.example.finalprojectbackend.model.User;
import com.example.finalprojectbackend.service.EmailService;
import com.example.finalprojectbackend.util.ErrorMessage;
import jakarta.annotation.security.PermitAll;
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
            emailService.sendRegistrationEmail(user);
            return ResponseEntity.ok(ErrorMessage.EMAIL_SENT.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ErrorMessage.EMAIL_NOT_SENT.getMessage());
        }
    }

    @GetMapping("/userList")
    @PermitAll
    public ResponseEntity<List<User>> userList(){
        try {
            //return user list but with no password
            List<User> userList =User.users
                            .stream()
                            .map(newUser -> new User(
                                    newUser.getName(),
                                    newUser.getLastName(),
                                    newUser.getEmail(),
                                    newUser.getRole()
                                    )
                            ).toList();

            return ResponseEntity.ok(userList);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
