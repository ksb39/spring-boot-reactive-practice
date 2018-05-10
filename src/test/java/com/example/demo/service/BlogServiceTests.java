package com.example.demo.service;

import com.example.demo.document.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTests {

	@Autowired
	private BlogService blogService;

	@Test
	public void test1() {
		Blog blog = new Blog();
		blog.setAuthor("test_");
		blog.setTitle("test_Title");
		blog.setContent("test_Content");

		Mono<Blog> result = blogService.createBlog(blog);

		System.out.println();
	}

}
