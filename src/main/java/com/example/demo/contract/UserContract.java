package com.example.demo.contract;

import com.example.demo.model.entities.User;
import com.example.demo.model.enums.Role;

public class UserContract {
    public UserContract() {
    }

    public UserContract(User model) {
        this.username = model.getUsername();
        this.id = model.getId();
        this.role = model.getRole();
    }

    private String username;
    private Long id;

    private Role role;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
