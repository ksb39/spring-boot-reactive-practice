package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {

    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

}
