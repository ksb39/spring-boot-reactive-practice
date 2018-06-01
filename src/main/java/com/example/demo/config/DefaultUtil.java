package com.example.demo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DefaultUtil {

    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

}
