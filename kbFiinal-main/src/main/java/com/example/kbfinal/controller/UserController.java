package com.example.kbfinal.controller;

import com.example.kbfinal.entity.User;
import com.example.kbfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/")
@Controller
public class UserController {

    // user 정보를 입력, 삭제, 수정하는 API 생성
    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public void createUser(Long id, String username, String password, Long age, String email, String cellphone) {
        User user = new User(id, username, password, age, email, cellphone);
        this.userService.registerUser(user);
    }

    @PutMapping("/update/{id}")
    public void changePassword (@PathVariable Long id, @RequestBody String newPassword) {
        userService.changePassword(id, newPassword);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // 전체 user List를 조회하는 api 생성

    @GetMapping("/readAll")
    public ResponseEntity<List<User>> selectAll(){
        List<User> userList = userService.selectAll();
        if (userList != null) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 전체 user 의 숫자를 조회하는 api 생성
    @GetMapping("/userCount")
    public long userCount(){
        long count = userService.userCount();
        return count;
    }

}
