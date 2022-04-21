package com.example.demo.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.TokenStore;
import com.example.demo.annotations.RoleGuard;
import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.UserContract;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.UnauthorizedException;
import com.example.demo.model.entities.ActingSubstance;
import com.example.demo.model.entities.User;
import com.example.demo.model.enums.Role;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.implementations.UserService;
import com.example.demo.services.interfaces.IActingSubstancesService;

import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<UserContract> login(@RequestBody UserContract userContract, HttpServletResponse response) {
        if (userContract == null) throw new BadRequestException();
        
        User user = userService.authorize(userContract);

        String token = TokenStore.makeToken(user.getId());
        Cookie tokenCookie = new Cookie("token", token);

        // expires in 7 days
        tokenCookie.setMaxAge(7 * 24 * 60 * 60);
        tokenCookie.setPath("/");

        response.addCookie(tokenCookie);

        return new ResponseEntity<>(new UserContract(user), HttpStatus.OK);
    }

    @GetMapping
    @RoleGuard(roles = {Role.ADMIN})
    public ResponseEntity<List<UserContract>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(
                users.stream().map(UserContract::new).collect(Collectors.toUnmodifiableList()),
                HttpStatus.OK);
    }

    @PostMapping
    @RoleGuard(roles = { Role.ADMIN })
    public ResponseEntity<UserContract> createUser(@RequestBody UserContract userContract) {
        return new ResponseEntity<>(new UserContract(userService.createUser(userContract)), HttpStatus.CREATED);
    }

    @PutMapping
    @RoleGuard(roles = { Role.ADMIN })
    public ResponseEntity<UserContract> updateUser(@RequestBody UserContract userContract) {
        return new ResponseEntity<>(new UserContract(userService.updateUser(userContract)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    @RoleGuard(roles = { Role.ADMIN })
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/me")
    public ResponseEntity<UserContract> getCurrentUser(@CookieValue("token") String token) {
        try {
            var uid = TokenStore.getUserIdByToken(token);
            var user = userService.getById(uid).orElseThrow(NotFoundException::new);
            return new ResponseEntity<>(new UserContract(user), HttpStatus.OK);
        } catch (UnauthorizedException e) {
            throw new NotFoundException();
        }
    }
}
