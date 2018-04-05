package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test1() {
		Flux<String> flux = Flux.just("red", "white", "blue");

		System.out.println();
	}

}
