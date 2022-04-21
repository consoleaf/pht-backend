package com.example.demo.services.interfaces;

import com.example.demo.contract.UserContract;
import com.example.demo.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User updateOrCreate(UserContract userContract);

    User authorize(UserContract contract);

    Optional<User> getById(Long id);

    List<User> getUsers();

    User createUser(UserContract contract);

    User updateUser(UserContract contract);

    void deleteUser(Long id);
}
