package com.example.demo.controller;


import java.util.List;

import com.example.demo.TokenStore;
import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.UserContract;
import com.example.demo.model.entities.ActingSubstance;
import com.example.demo.model.entities.User;
import com.example.demo.services.implementations.UserService;
import com.example.demo.services.interfaces.IActingSubstancesService;

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
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserContract> login(@RequestBody UserContract userContract, HttpServletResponse response) {
        User user = userService.authorize(userContract);

        String token = TokenStore.makeToken(user.getId());
        Cookie tokenCookie = new Cookie("token", token);

        // expires in 7 days
        tokenCookie.setMaxAge(7 * 24 * 60 * 60);
        tokenCookie.setPath("/");

        response.addCookie(tokenCookie);

        return new ResponseEntity<>(new UserContract(user), HttpStatus.OK);
    }
}
