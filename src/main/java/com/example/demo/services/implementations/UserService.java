package com.example.demo.services.implementations;

import com.example.demo.contract.UserContract;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.UnauthorizedException;
import com.example.demo.model.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.interfaces.IUserService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User updateOrCreate(UserContract contract) {

        User user =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(User::new);

        Util.assignIfNotNull(contract::getPassword, user::setPassword);
        Util.assignIfNotNull(contract::getUsername, user::setUsername);
        Util.assignIfNotNull(contract::getRole, user::setRole);

        return user;
    }

    @Override
    public User authorize(UserContract contract) {
        User user = repository.findByUsername(contract.getUsername()).orElseThrow(NotFoundException::new);
        if (!user.checkPassword(contract.getPassword())) throw new UnauthorizedException("Wrong password");
        return user;
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }
}
