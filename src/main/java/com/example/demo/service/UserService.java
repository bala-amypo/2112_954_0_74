package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User login(String email, String password);

    User getUser(Long id);
}
