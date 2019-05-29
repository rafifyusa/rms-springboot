package com.mitrais.rmsspringboot.service;

import com.mitrais.rmsspringboot.model.User;

import java.util.List;

public interface UserService {
    boolean insert(User user);
    boolean update(String name, String password, Long id);
    boolean delete(Long id);
    List<User> findAll();
}
