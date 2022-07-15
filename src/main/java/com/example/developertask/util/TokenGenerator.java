package com.example.developertask.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.UUID;


@Component
public class TokenGenerator {

    public static String generate(String name) {
        return UUID.nameUUIDFromBytes((name + System.currentTimeMillis()).getBytes()).toString();
    }
}
