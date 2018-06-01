package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void TEST() {
//		User user1 = new User();
//		user1.setEmail("user");
//		user1.setPassword("$2a$10$KoxHNdhOe6OY88Ybq6T2d.SGp6lVfj5ynY/QwaO5SRk998TgnYayi");
//		user1.setRole(Role.USER);
//		user1.setDelete(true);
//
//		User user = userRepository.save(user1).block();

//		userRepository.findOneByEmail();

		System.out.println();
	}

}
