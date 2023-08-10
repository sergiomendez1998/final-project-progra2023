package com.example.finalprojectbackend.lab2you.service;

import com.example.finalprojectbackend.lab2you.db.model.UserEntity;
import com.example.finalprojectbackend.lab2you.db.model.UserWrapper;
import com.example.finalprojectbackend.lab2you.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
   public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserWrapper> executedReadAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserWrapper(user, user.getRoles()))
                .toList();
    }

}
