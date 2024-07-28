package com.example.kbfinal.service;

import com.example.kbfinal.entity.User;
import com.example.kbfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void registerUser(User user) {
        // 비밀번호를 암호화하여 저장
        // password를 인코딩
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // user entity에 인코딩 된 password를 넣기
        userRepository.save(user);

    }

   public boolean authenticate(String username, String password) {
       // 사용자 조회
       User user = userRepository.findByUsername(username); // 직접 repo에서 구현
       if (user == null) {
           return false;
       }
       // 입력된 비밀번호와 저장된 암호화된 비밀번호를 비교
       return passwordEncoder.matches(password, user.getPassword());

   }

    // 이후 컨트롤러에서 들어오게 될  내용 추가 구현하기

    public void changePassword(Long id, String newPassword) {
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("수정에 실패하였습니다.");
            }
        });

        user.setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> selectAll() {
        List<User> userAll = userRepository.findAll();
        return userAll;
    }

    public long userCount() {
        long count = userRepository.count();
        return count;
    }
}
