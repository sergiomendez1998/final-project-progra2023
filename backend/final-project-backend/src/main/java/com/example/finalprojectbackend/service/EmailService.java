package com.example.finalprojectbackend.service;


import com.example.finalprojectbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

   private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendRegistrationEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Welcome to lab2you!");
        message.setText("Hello " + user.getName() + " " + user.getLastName()
                + ",\n\n" + "Your account has been created successfully.\n\n"
                + "Your username is: "
                + user.getUserName() + "\n" + "Your password is: "
                + user.getPassword() + "\n\n" + "Thank you for choosing lab2you where we make your life easier!\n\n"
                + "Best regards,\n"
                + "lab2you team");
        javaMailSender.send(message);
    }
}
