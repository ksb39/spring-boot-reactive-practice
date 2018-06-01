package com.example.demo.config;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        initUser();
        initTask();
    }

    private void initTask() {
        taskService.reset();
    }

    private void initUser() {
        final String email1 = "user";
        final String email2 = "admin";
        final String email3 = "expired";
        final String password = "password";

        User user1 = new User(email1,
                password,
                Role.USER);

        User user2 = new User(email2,
                password,
                Role.ADMIN);

        User user3 = new User(email3,
                password,
                Role.USER);

        if(userRepository.findOneByEmail(email1).block() == null) userRepository.save(user1).block();
        if(userRepository.findOneByEmail(email2).block() == null) userRepository.save(user2).block();
        if(userRepository.findOneByEmail(email3).block() == null) userRepository.save(user3).block();
    }

}
