package com.example.kbfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class KbFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(KbFinalApplication.class, args);
    }

}
