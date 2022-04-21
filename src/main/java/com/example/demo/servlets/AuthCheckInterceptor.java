package com.example.demo.servlets;

import com.example.demo.TokenStore;
import com.example.demo.annotations.RoleGuard;
import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.exceptions.UnauthorizedException;
import com.example.demo.services.implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler
    ) {
        var cookies = request.getCookies();
        String token = null;
        for (var cookie:
                cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }

        if (handler instanceof HandlerMethod) {
            var roleGuard = ((HandlerMethod) handler).getMethodAnnotation(RoleGuard.class);

            if (roleGuard != null) {
                var userId = TokenStore.getUserIdByToken(token);
                var User = userService.getById(userId).orElseThrow(UnauthorizedException::new);

                if (Arrays.stream(roleGuard.roles()).noneMatch(User.getRole()::equals)) {
                    throw new ForbiddenException();
                }
            }
        }

        return true;
    }
}
