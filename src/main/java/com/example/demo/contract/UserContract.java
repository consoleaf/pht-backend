package com.example.demo.contract;

import com.example.demo.model.entities.User;
import com.example.demo.model.enums.Role;

public class UserContract {
    public UserContract() {
    }

    public UserContract(User model) {
        this.email = model.getEmail();
        this.id = model.getId();
        this.role = model.getRole();
        this.name = model.getName();
    }

    private String email;
    private Long id;

    private String name;
    private Role role;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
