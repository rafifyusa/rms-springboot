package com.mitrais.rmsspringboot.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {
    @Id
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String name;
    @Size(min = 4)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn (name = "USER_EMAIL", referencedColumnName = "email")
    }, inverseJoinColumns =  {@JoinColumn (name = "ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    public User() { }

    public User(String name, String password, List<Role> roles, String email) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
/*        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);*/
    this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
