package com.example.demo.repository;

import com.example.demo.domain.Sex;
import com.example.demo.domain.User;
import com.example.demo.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    @Test
    void findByUserId(){
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.findByUserId(1);
    }

    @Test
    void deleteById(){
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.deleteById(1);
    }

    @Test
    void save() {
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setAge(10);
        user.setBirthday(LocalDate.of(2000, 1, 1));
        user.setUsername("tom");
        user.setPassword("123456");
        user.setMobile("123456");
        user.setSex(Sex.M);
        assertEquals(1, userRepository.save(user));
    }

    @Test
    void findByUsernameAngPassword() {
        UserRepository userRepository = new UserRepositoryImpl();
        System.out.println(userRepository.findByUsernameAngPassword("tom", "123456"));
    }
}