package com.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String abc = "123";
        System.out.println(encoder.encode(abc));
    }
}
