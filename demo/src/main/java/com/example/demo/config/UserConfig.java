package com.example.demo.config;

import com.example.demo.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner (UserRepo userRepo){
        return args -> {
            Student Suhas = new Student(24,"Suhas", "S@email", "Suresh");
            Student Chandan = new Student(24, "Chandan", "C@email", "P ");
            userRepo.saveAll(List.of(Suhas,Chandan));
        };
    }
}
