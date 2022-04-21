package com.example.demo;

import com.example.demo.exceptions.UnauthorizedException;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.HashMap;

public class TokenStore {
    private static final HashMap<String, Long> tokenToUserIdMap = new HashMap<>();
    private static final SecureRandom secureRandom = new SecureRandom();

    public static Long getUserIdByToken(String token) {
        if (!tokenToUserIdMap.containsKey(token)) {
            throw new UnauthorizedException();
        }
        return tokenToUserIdMap.get(token);
    }

    public static String makeToken(Long userId) {
        String token = RandomStringUtils.randomAlphanumeric(64);
        tokenToUserIdMap.put(token, userId);
        return token;
    }
}
