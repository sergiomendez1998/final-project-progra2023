package com.example.finalprojectbackend.lab2you;
import com.example.finalprojectbackend.lab2you.db.model.Role;
import com.example.finalprojectbackend.lab2you.db.model.User;
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
            Role role = new Role();
            Role role2 = new Role();
            role.setName("ROLE_ADMIN");
            role2.setName("ROLE_USER");
            user.setName("sergio");
            user.setLastName("mendez");
            user.setUserName("smendez");
            user.setPassword("$2a$10$9Ff.gEdemfpAJI2fZiEtFO7Qgd4dIabWziX/f8asBA6H1g4Ly87Bu");
            user.setEmail("sergio@gmail.com");
            user.addRole(role);
            user.addRole(role2);

            User user2 = new User();
            Role role3 = new Role();


            role3.setName("ROLE_ANALYST");
            user2.setName("jose");
            user2.setLastName("jose");
            user2.setUserName("jose");
            user2.setPassword("$2a$10$9Ff.gEdemfpAJI2fZiEtFO7Qgd4dIabWziX/f8asBA6H1g4Ly87Bu");
            user2.setEmail("jose@gmail.com");

            user2.addRole(role3);
            User.users.add(user);
            User.users.add(user2);
        };
    }

}
