package com.example.kbfinal.config;

import com.example.kbfinal.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // decoder 구현
    public boolean passwordDecoder(String inputPw, User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(inputPw, user.getPassword())){
            return true;
        }else {
            return false;
        }
    }


}
