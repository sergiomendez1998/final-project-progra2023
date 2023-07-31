package com.example.finalprojectbackend;
import com.example.finalprojectbackend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Data {
    private static final Logger log = LoggerFactory.getLogger(Data.class);

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            User user = new User();
            user.setName("sergio");
            user.setLastName("mendez");
            user.setUserName("smendez");
            user.setPassword("$2a$10$9Ff.gEdemfpAJI2fZiEtFO7Qgd4dIabWziX/f8asBA6H1g4Ly87Bu");
            user.setEmail("sergio@gmail.com");
            user.setRole("admin");
            User.users.add(user);
        };
    }

}
