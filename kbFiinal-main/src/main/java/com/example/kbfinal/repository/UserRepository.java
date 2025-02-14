package com.example.kbfinal.repository;

import com.example.kbfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM users u WHERE u.username = ?1", nativeQuery=true)
    User findByUsername(String username);

}
