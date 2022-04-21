package com.example.demo.services.implementations;

import com.example.demo.contract.UserContract;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.UnauthorizedException;
import com.example.demo.model.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.interfaces.IUserService;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Util.assignIfNotNull(contract::getEmail, user::setEmail);
        Util.assignIfNotNull(contract::getRole, user::setRole);
        Util.assignIfNotNull(contract::getName, user::setName);

        return user;
    }

    @Override
    public User authorize(UserContract contract) {
        User user = repository.findByEmail(contract.getEmail()).orElseThrow(NotFoundException::new);
        if (!user.checkPassword(contract.getPassword())) throw new UnauthorizedException("Wrong password");
        return user;
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User createUser(UserContract contract) {
        if (contract.getId() != null) throw new BadRequestException("New user needs empty ID");
        User user = updateOrCreate(contract);
        return repository.save(user);
    }

    @Override
    public User updateUser(UserContract contract) {
        if (contract.getId() == null) throw new BadRequestException("You have to provider user.id");
        User user = updateOrCreate(contract);
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new NotFoundException(String.format("User with id %d doesn't exist", id));
    }
}
