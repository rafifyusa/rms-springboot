package com.mitrais.rmsspringboot.repository;

import com.mitrais.rmsspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Query("update User u set u.name = ?1, u.password = ?2 where u.id = ?3")
    void updateUser (String name, String password, Long id);
}
