package com.example.finalprojectbackend;

import com.example.finalprojectbackend.lab2you.Lab2YouUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectBackendApplication {

    public static void main(String[] args) {
//        System.out.println(Lab2YouUtils.encodePassword("123456"));
        SpringApplication.run(FinalProjectBackendApplication.class, args);
    }

}
