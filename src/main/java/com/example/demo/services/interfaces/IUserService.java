package com.example.demo.services.interfaces;

import com.example.demo.contract.UserContract;
import com.example.demo.model.entities.User;

import java.util.Optional;

public interface IUserService {
    User updateOrCreate(UserContract userContract);

    User authorize(UserContract contract);

    Optional<User> getById(Long id);
}
