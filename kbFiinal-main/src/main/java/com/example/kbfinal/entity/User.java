package com.example.kbfinal.entity;

import jakarta.persistence.*;
import lombok.Data;

// lombok 사용할것
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    // 추가로 3개의 attribute 를 만들기
    private Long age;
    private String email;
    private String cellphone;

    public User(){
        super();
    }

    public User(Long id, String username, String password, Long age, String email, String cellphone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.cellphone = cellphone;
    }
}
