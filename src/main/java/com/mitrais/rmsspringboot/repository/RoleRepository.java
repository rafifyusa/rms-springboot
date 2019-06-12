package com.mitrais.rmsspringboot.repository;

import com.mitrais.rmsspringboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
