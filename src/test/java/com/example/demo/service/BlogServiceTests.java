package com.example.demo.service;

import com.example.demo.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTests {

	@Autowired
	private PostService blogService;

	@Test
	public void test1() {
		Post blog = new Post();
		blog.setAuthor("test_");
		blog.setTitle("test_Title");
		blog.setContent("test_Content");

		Mono<Post> result = blogService.createBlog(blog);

		System.out.println();
	}

}
