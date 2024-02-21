package com.example.aftasapi;

import com.example.aftasapi.DTOs.Requests.SignUpRequest;
import com.example.aftasapi.Entities.Role;
import com.example.aftasapi.Entities.User;
import com.example.aftasapi.Repositories.UserRepository;
import com.example.aftasapi.Services.Impl.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AftasApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AftasApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            UserRepository userRepository,PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByEmail("manager@aftas.ma").isEmpty()) {

                var manager = User.builder()
                        .email("manager@aftas.ma")
                        .name("manager general")
                        .password(passwordEncoder.encode("123456"))
                        .role(Role.MANAGER)
                        .build();
                userRepository.save(manager);
            }
            ;
        };
    }

}
