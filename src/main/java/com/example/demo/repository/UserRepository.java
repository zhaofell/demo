package com.example.demo.repository;

import com.example.demo.domain.User;

import java.util.List;

public interface UserRepository {
    int save(User user);

    User findByUsernameAngPassword(String username, String password);
    List<User> findAll();

    int deleteById(int userId);
    User findByUserId(int userId);
    int update(User user);

}


