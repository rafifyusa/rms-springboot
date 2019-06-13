package com.mitrais.rmsspringboot.service.Implementation;

import com.mitrais.rmsspringboot.model.Role;
import com.mitrais.rmsspringboot.model.User;
import com.mitrais.rmsspringboot.repository.UserRepository;
import com.mitrais.rmsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserServiceImpl(){}

    @Override
    public boolean insert(User user) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            Role role = new Role("USER");
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
            userRepository.save(user);
            return true;
        }catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertAdmin(User user) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));

            Role role = new Role("ADMIN");
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
            userRepository.save(user);
            return true;

        }catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean update(String name, String password, String email) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userRepository.updateUser(name, encoder.encode(password), email);
            return true;
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean delete(String email) {
        try {
            userRepository.deleteUserByEmail(email);
            return true;
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            return userRepository.findUserByEmail(email);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
