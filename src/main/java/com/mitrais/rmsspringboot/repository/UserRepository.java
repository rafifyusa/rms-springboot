package com.mitrais.rmsspringboot.repository;

import com.mitrais.rmsspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Query("update User u set u.name = ?1, u.password = ?2 where u.email = ?3")
    void updateUser (String name, String password, String email);

    Optional<User> findUserByEmail(String email);
    void deleteUserByEmail(String email);
}
