package com.mitrais.rmsspringboot.service.Implementation;

import com.mitrais.rmsspringboot.model.User;
import com.mitrais.rmsspringboot.repository.UserRepository;
import com.mitrais.rmsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean insert(User user) {
        try {
            userRepository.save(user);
            return true;
        }catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(String name, String password, Long id) {
        try {
             return userRepository.updateUser(name, password, id);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
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
}
