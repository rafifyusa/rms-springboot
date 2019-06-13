package com.mitrais.rmsspringboot.service;

import com.mitrais.rmsspringboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean insert(User user);
    boolean update(String name, String password, String email);
    boolean delete(String email);
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
