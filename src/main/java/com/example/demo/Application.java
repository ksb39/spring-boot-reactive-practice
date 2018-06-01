package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
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
